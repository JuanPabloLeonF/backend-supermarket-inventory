package dev.juanleon.supermarket_inventory.modules.cash_register.domain.services.delete;

import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseModel;

import java.util.UUID;

public interface IDeleteCashRegisterService {
    ResponseModel deleteById(UUID id);
}
