package dev.juanleon.supermarket_inventory.cash_register.application.handler.post;

import dev.juanleon.supermarket_inventory.cash_register.application.dto.CashRegisterRequest;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseRequestDto;

public interface IPostCashRegisterHandler {
    ResponseRequestDto create(CashRegisterRequest cashRegisterRequest);
}
