package dev.juanleon.supermarket_inventory.categories.domain.persistence.delete;

import java.util.UUID;

public interface IDeleteCategoriesPersistence {
    String deleteById(UUID id);
}
