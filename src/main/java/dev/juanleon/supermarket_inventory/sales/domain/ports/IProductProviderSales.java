package dev.juanleon.supermarket_inventory.sales.domain.ports;

import dev.juanleon.supermarket_inventory.products.domain.models.ProductModel;

import java.util.List;
import java.util.UUID;

public interface IProductProviderSales {
    List<ProductModel> getProductsByIds(List<UUID> idList);
}
