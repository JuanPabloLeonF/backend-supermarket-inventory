package dev.juanleon.supermarket_inventory.modules.products.domain.persistence.update;

import dev.juanleon.supermarket_inventory.modules.products.domain.models.ProductModel;

import java.util.UUID;

public interface IUpdateProductPersistence {
    String update(UUID productId, ProductModel productModel);
    String updateActive(UUID productId, Boolean active);
    String updateUrlImg(UUID productId, String urlImg);
}
