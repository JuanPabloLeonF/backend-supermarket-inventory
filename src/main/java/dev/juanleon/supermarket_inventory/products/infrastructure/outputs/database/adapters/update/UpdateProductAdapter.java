package dev.juanleon.supermarket_inventory.products.infrastructure.outputs.database.adapters.update;

import dev.juanleon.supermarket_inventory.products.domain.models.ProductModel;
import dev.juanleon.supermarket_inventory.products.domain.persistence.update.IUpdateProductPersistence;
import dev.juanleon.supermarket_inventory.products.infrastructure.outputs.database.entities.ProductEntity;
import dev.juanleon.supermarket_inventory.products.infrastructure.outputs.database.mappers.IMapperProductInfrastructure;
import dev.juanleon.supermarket_inventory.products.infrastructure.outputs.database.repositories.IProductRepository;
import dev.juanleon.supermarket_inventory.products.infrastructure.outputs.exceptions.NotFoundProductException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.UUID;

import static dev.juanleon.supermarket_inventory.common.utils.enums.MessagesApp.PRODUCT_UPDATE_SUCCESSFULLY_BY_ID;

@Repository
@RequiredArgsConstructor
public class UpdateProductAdapter implements IUpdateProductPersistence {

    private final IProductRepository iProductRepository;
    private final IMapperProductInfrastructure iMapperProductInfrastructure;

    @Override
    public String update(UUID productId, ProductModel productModel) {

        ProductEntity entity = this.iMapperProductInfrastructure.toEntity(productModel);

        return this.iProductRepository.findById(productId)
                .map(product -> {
                    product.setCategoriesEntity(entity.getCategoriesEntity());
                    product.setCode(entity.getCode());
                    product.setName(entity.getName());
                    product.setDescription(entity.getDescription());
                    product.setUnitMeasurement(entity.getUnitMeasurement());
                    product.setPriceSale(entity.getPriceSale());
                    product.setPricePurchase(entity.getPricePurchase());
                    product.setStock(entity.getStock());
                    product.setUpdatedAt(entity.getUpdatedAt());
                    this.iProductRepository.save(product);
                    return PRODUCT_UPDATE_SUCCESSFULLY_BY_ID.format(product.getId());
                }).orElseThrow(() -> new NotFoundProductException(productId));
    }

    @Override
    public String updateActive(UUID productId, Boolean active, LocalDate localDate) {
        return this.iProductRepository.findById(productId)
                .map(product -> {
                    product.setActive(active);
                    product.setUpdatedAt(localDate);
                    this.iProductRepository.save(product);
                    return PRODUCT_UPDATE_SUCCESSFULLY_BY_ID.format(product.getId());
                }).orElseThrow(() -> new NotFoundProductException(productId));
    }
}
