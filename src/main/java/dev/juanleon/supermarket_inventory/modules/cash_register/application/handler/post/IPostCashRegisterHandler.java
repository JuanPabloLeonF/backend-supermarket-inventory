package dev.juanleon.supermarket_inventory.modules.cash_register.application.handler.post;

import dev.juanleon.supermarket_inventory.modules.cash_register.application.dto.CashRegisterRequest;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseRequestDto;

public interface IPostCashRegisterHandler {
    ResponseRequestDto create(CashRegisterRequest cashRegisterRequest);
}
