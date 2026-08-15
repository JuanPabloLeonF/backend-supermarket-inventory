package dev.juanleon.supermarket_inventory.modules.providers.domain.persistence.update;

import dev.juanleon.supermarket_inventory.modules.providers.domain.models.ProviderModel;

import java.util.UUID;

public interface IUpdateProviderPersistence {
    String updateById(ProviderModel providerModel, UUID id);
}
