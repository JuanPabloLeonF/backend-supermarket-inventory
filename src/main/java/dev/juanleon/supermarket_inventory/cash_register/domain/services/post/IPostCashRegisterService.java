package dev.juanleon.supermarket_inventory.cash_register.domain.services.post;

import dev.juanleon.supermarket_inventory.cash_register.domain.models.CashRegisterModel;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseModel;

public interface IPostCashRegisterService {
    ResponseModel create(CashRegisterModel cashRegisterModel);
}
