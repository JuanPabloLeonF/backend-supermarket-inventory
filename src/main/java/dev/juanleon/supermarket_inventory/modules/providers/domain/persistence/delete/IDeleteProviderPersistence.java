package dev.juanleon.supermarket_inventory.modules.providers.domain.persistence.delete;

import java.util.UUID;

public interface IDeleteProviderPersistence {
    String deleteById(UUID id);
}
