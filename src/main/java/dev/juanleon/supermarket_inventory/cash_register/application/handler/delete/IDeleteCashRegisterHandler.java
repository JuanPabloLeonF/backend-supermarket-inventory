package dev.juanleon.supermarket_inventory.cash_register.application.handler.delete;

import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseRequestDto;

import java.util.UUID;

public interface IDeleteCashRegisterHandler {
    ResponseRequestDto deleteById(UUID id);
}
