package dev.juanleon.supermarket_inventory.modules.purchases.domain.models;

import java.util.Map;
import java.util.UUID;

public record PostDataBusinessPurchase(
        PurchaseModel purchaseModel,
        Map<UUID, Integer> newStockMap
) {
}
