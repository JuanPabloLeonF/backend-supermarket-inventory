package dev.juanleon.supermarket_inventory.products.infrastructure.outputs.providers;

import dev.juanleon.supermarket_inventory.products.domain.models.ProductModel;
import dev.juanleon.supermarket_inventory.products.infrastructure.outputs.database.entities.ProductEntity;
import dev.juanleon.supermarket_inventory.products.infrastructure.outputs.database.mappers.IMapperProductInfrastructure;
import dev.juanleon.supermarket_inventory.products.infrastructure.outputs.database.repositories.IProductRepository;
import dev.juanleon.supermarket_inventory.products.infrastructure.outputs.exceptions.ProductsContainsDuplicateException;
import dev.juanleon.supermarket_inventory.products.infrastructure.outputs.exceptions.ProductsFollowingAreInactivesException;
import dev.juanleon.supermarket_inventory.products.infrastructure.outputs.exceptions.ProductsFollowingNotExistException;
import dev.juanleon.supermarket_inventory.sales.domain.ports.IProductProviderSales;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;


@Component
@RequiredArgsConstructor
public class SalesProductProviderAdapter implements IProductProviderSales {

    private final IProductRepository iProductRepository;
    private final IMapperProductInfrastructure iMapperProductInfrastructure;

    @Override
    public List<ProductModel> getProductsByIds(List<UUID> idList) {

        Set<UUID> uniqueIds = new HashSet<>(idList);

        if (uniqueIds.size() != idList.size()) {
            throw new ProductsContainsDuplicateException(idList);
        }

        List<ProductEntity> productEntityList = this.iProductRepository.findAllById(idList);

        Set<UUID> foundIds = productEntityList.stream()
                .map(ProductEntity::getId)
                .collect(Collectors.toSet());

        List<UUID> missingIds = idList.stream()
                .filter(id -> !foundIds.contains(id))
                .toList();

        if (!missingIds.isEmpty()) {
            throw new ProductsFollowingNotExistException(missingIds);
        }

        List<UUID> inactiveIds = productEntityList.stream()
                .filter(product -> !Boolean.TRUE.equals(product.getActive()))
                .map(ProductEntity::getId)
                .toList();

        if (!inactiveIds.isEmpty()) {
            throw new ProductsFollowingAreInactivesException(inactiveIds);
        }

        return productEntityList.stream()
                .map(this.iMapperProductInfrastructure::toModel)
                .toList();
    }
}
