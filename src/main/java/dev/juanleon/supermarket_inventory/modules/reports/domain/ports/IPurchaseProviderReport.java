package dev.juanleon.supermarket_inventory.modules.reports.domain.ports;

import dev.juanleon.supermarket_inventory.modules.purchases.domain.models.PurchaseModel;

import java.util.UUID;

public interface IPurchaseProviderReport {
    PurchaseModel getPurchaseById(UUID idPurchase, UUID idEmployee, UUID idProvider);
}
