package dev.juanleon.supermarket_inventory.modules.purchases.domain.ports;

import dev.juanleon.supermarket_inventory.modules.providers.domain.models.ProviderModel;

import java.util.UUID;

public interface IProviderProviderPurchase {
    ProviderModel getProviderById(UUID id);
}
