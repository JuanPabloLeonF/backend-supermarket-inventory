package dev.juanleon.supermarket_inventory.modules.providers.domain.persistence.post;

import dev.juanleon.supermarket_inventory.modules.providers.domain.models.ProviderModel;

public interface IPostProviderPersistence {
    String create(ProviderModel providerModel);
}
