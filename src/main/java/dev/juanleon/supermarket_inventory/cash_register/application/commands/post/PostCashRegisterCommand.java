package dev.juanleon.supermarket_inventory.cash_register.application.commands.post;

import dev.juanleon.supermarket_inventory.cash_register.application.dto.CashRegisterRequest;
import dev.juanleon.supermarket_inventory.common.mediator.IRequest;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseRequestDto;

public record PostCashRegisterCommand(CashRegisterRequest cashRegisterRequest) implements IRequest<ResponseRequestDto> { }
