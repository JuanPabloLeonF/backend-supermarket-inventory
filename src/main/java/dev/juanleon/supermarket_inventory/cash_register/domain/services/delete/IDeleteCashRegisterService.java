package dev.juanleon.supermarket_inventory.cash_register.domain.services.delete;

import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseModel;

import java.util.UUID;

public interface IDeleteCashRegisterService {
    ResponseModel deleteById(UUID id);
}
