package dev.juanleon.supermarket_inventory.products.infrastructure.outputs.database.adapters.post;

import dev.juanleon.supermarket_inventory.products.domain.models.ProductModel;
import dev.juanleon.supermarket_inventory.products.domain.persistence.post.IPostProductPersistence;
import dev.juanleon.supermarket_inventory.products.infrastructure.outputs.database.entities.ProductEntity;
import dev.juanleon.supermarket_inventory.products.infrastructure.outputs.database.mappers.IMapperProductInfrastructure;
import dev.juanleon.supermarket_inventory.products.infrastructure.outputs.database.repositories.IProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

import static dev.juanleon.supermarket_inventory.common.utils.enums.MessagesApp.PRODUCT_CREATED_SUCCESSFULLY;

@Repository
@RequiredArgsConstructor
public class PostProductAdapter implements IPostProductPersistence {

    private final IProductRepository iProductRepository;
    private final IMapperProductInfrastructure iMapperProductInfrastructure;

    @Override
    public String create(ProductModel productModel) {
        ProductEntity entity = this.iMapperProductInfrastructure.toEntity(productModel);
        UUID id = this.iProductRepository.save(entity).getId();
        return PRODUCT_CREATED_SUCCESSFULLY.format(id);
    }
}
