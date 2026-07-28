package dev.juanleon.supermarket_inventory.products.domain.persistence.update;

import dev.juanleon.supermarket_inventory.products.domain.models.ProductModel;

import java.time.LocalDate;
import java.util.UUID;

public interface IUpdateProductPersistence {
    String update(UUID productId, ProductModel productModel);
    String updateActive(UUID productId, Boolean active, LocalDate localDate);
}
