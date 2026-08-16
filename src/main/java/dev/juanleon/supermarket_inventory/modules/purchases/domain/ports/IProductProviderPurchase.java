package dev.juanleon.supermarket_inventory.modules.purchases.domain.ports;

import dev.juanleon.supermarket_inventory.modules.products.domain.models.ProductModel;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface IProductProviderPurchase {
    List<ProductModel> getProductsByIds(List<UUID> idList);
    void updateStockProductsByIds(Map<UUID, Integer> productStockMap, List<ProductModel> productModelList);
}
