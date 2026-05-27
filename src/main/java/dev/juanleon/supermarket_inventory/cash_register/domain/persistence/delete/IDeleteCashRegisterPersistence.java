package dev.juanleon.supermarket_inventory.cash_register.domain.persistence.delete;

import java.util.UUID;

public interface IDeleteCashRegisterPersistence {
    String deleteById(UUID id);
}
