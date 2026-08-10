package dev.juanleon.supermarket_inventory.modules.cash_register.application.commands.delete;

import dev.juanleon.supermarket_inventory.share.mediator.IRequest;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseRequestDto;

import java.util.UUID;

public record DeleteCashRegisterCommand (UUID id) implements IRequest<ResponseRequestDto> {}
