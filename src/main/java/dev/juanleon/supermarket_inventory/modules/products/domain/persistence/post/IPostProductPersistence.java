package dev.juanleon.supermarket_inventory.modules.products.domain.persistence.post;

import dev.juanleon.supermarket_inventory.modules.products.domain.models.ProductModel;

public interface IPostProductPersistence {
    String create(ProductModel productModel);
}
