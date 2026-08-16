package dev.juanleon.supermarket_inventory.modules.purchases.domain.persistence.post;

import dev.juanleon.supermarket_inventory.modules.purchases.domain.models.PurchaseModel;

public interface IPostPurchasePersistence {
    String create(PurchaseModel purchaseModel);
}
