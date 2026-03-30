package dev.juanleon.supermarket_inventory.users.domain.persistence.delete;

import java.util.UUID;

public interface IDeleteUserPersistence {
    String deleteById(UUID id);
}
