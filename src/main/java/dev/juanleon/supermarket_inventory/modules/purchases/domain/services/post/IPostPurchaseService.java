package dev.juanleon.supermarket_inventory.modules.purchases.domain.services.post;

import dev.juanleon.supermarket_inventory.modules.purchases.domain.models.PurchaseModel;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseModel;

public interface IPostPurchaseService {
    ResponseModel create(PurchaseModel purchaseModel);
}
