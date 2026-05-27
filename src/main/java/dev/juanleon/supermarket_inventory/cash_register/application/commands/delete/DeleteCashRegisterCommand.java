package dev.juanleon.supermarket_inventory.cash_register.application.commands.delete;

import dev.juanleon.supermarket_inventory.common.mediator.IRequest;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseRequestDto;

import java.util.UUID;

public record DeleteCashRegisterCommand (UUID id) implements IRequest<ResponseRequestDto> {}
