package dev.juanleon.supermarket_inventory.modules.products.infrastructure.outputs.providers;

import dev.juanleon.supermarket_inventory.modules.products.domain.models.ProductModel;
import dev.juanleon.supermarket_inventory.modules.products.infrastructure.outputs.database.entities.ProductEntity;
import dev.juanleon.supermarket_inventory.modules.products.infrastructure.outputs.database.mappers.IMapperProductInfrastructure;
import dev.juanleon.supermarket_inventory.modules.products.infrastructure.outputs.database.repositories.IProductRepository;
import dev.juanleon.supermarket_inventory.modules.products.infrastructure.outputs.exceptions.ProductsContainsDuplicateException;
import dev.juanleon.supermarket_inventory.modules.products.infrastructure.outputs.exceptions.ProductsFollowingAreInactivesException;
import dev.juanleon.supermarket_inventory.modules.products.infrastructure.outputs.exceptions.ProductsFollowingNotExistException;
import dev.juanleon.supermarket_inventory.modules.purchases.domain.ports.IProductProviderPurchase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PurchaseProductProviderAdapter implements IProductProviderPurchase {

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

    @Override
    public void updateStockProductsByIds(Map<UUID, Integer> productStockMap, List<ProductModel> productModelList) {

        List<ProductEntity> productEntityList = productModelList.stream()
                .map(this.iMapperProductInfrastructure::toEntity)
                .toList();

        productEntityList.forEach(product -> {
            Integer stockNew = productStockMap.get(product.getId());
            product.setStock(stockNew);
        });

        this.iProductRepository.saveAll(productEntityList);
    }
}
