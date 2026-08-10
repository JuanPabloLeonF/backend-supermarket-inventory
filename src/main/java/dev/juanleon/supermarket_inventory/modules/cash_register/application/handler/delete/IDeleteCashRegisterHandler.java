package dev.juanleon.supermarket_inventory.modules.cash_register.application.handler.delete;

import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseRequestDto;

import java.util.UUID;

public interface IDeleteCashRegisterHandler {
    ResponseRequestDto deleteById(UUID id);
}
