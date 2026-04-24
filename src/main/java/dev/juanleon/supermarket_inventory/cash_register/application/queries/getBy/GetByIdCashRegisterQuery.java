package dev.juanleon.supermarket_inventory.cash_register.application.queries.getBy;

import dev.juanleon.supermarket_inventory.cash_register.application.dto.CashRegisterResponse;
import dev.juanleon.supermarket_inventory.common.mediator.IRequest;

import java.util.UUID;

public record GetByIdCashRegisterQuery(UUID id) implements IRequest<CashRegisterResponse> {}
