package dev.juanleon.supermarket_inventory.cash_register.application.queries.getAll;

import dev.juanleon.supermarket_inventory.cash_register.application.dto.CashRegisterResponse;
import dev.juanleon.supermarket_inventory.common.mediator.IRequest;
import dev.juanleon.supermarket_inventory.common.utils.dto.PagedResponse;

public record GetAllCashRegisterQuery(
        Integer page,
        Integer size
) implements IRequest<PagedResponse<CashRegisterResponse>> { }
