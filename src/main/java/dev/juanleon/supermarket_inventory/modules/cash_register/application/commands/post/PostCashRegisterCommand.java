package dev.juanleon.supermarket_inventory.modules.cash_register.application.commands.post;

import dev.juanleon.supermarket_inventory.modules.cash_register.application.dto.CashRegisterRequest;
import dev.juanleon.supermarket_inventory.share.mediator.IRequest;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseRequestDto;

public record PostCashRegisterCommand(CashRegisterRequest cashRegisterRequest) implements IRequest<ResponseRequestDto> { }
