package dev.juanleon.supermarket_inventory.modules.products.domain.persistence.delete;

import java.util.UUID;

public interface IDeleteProductPersistence {
    String deleteById(UUID id);
}
