package dev.juanleon.supermarket_inventory.modules.cash_register.domain.persistence.post;

import dev.juanleon.supermarket_inventory.modules.cash_register.domain.models.CashRegisterModel;

public interface IPostCashRegisterPersistence {
    String create(CashRegisterModel cashRegisterModel);
}
