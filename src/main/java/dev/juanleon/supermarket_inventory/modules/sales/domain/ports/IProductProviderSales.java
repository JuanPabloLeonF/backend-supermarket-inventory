package dev.juanleon.supermarket_inventory.modules.sales.domain.ports;

import dev.juanleon.supermarket_inventory.modules.products.domain.models.ProductModel;

import java.util.List;
import java.util.UUID;

public interface IProductProviderSales {
    List<ProductModel> getProductsByIds(List<UUID> idList);
}
