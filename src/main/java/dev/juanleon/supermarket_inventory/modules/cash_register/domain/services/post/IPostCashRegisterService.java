package dev.juanleon.supermarket_inventory.modules.cash_register.domain.services.post;

import dev.juanleon.supermarket_inventory.modules.cash_register.domain.models.CashRegisterModel;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseModel;

import java.util.UUID;

public interface IPostCashRegisterService {
    ResponseModel create(CashRegisterModel cashRegisterModel, UUID employeeId);
}
