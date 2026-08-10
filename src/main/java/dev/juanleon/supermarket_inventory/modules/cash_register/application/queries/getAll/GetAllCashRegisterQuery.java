package dev.juanleon.supermarket_inventory.modules.cash_register.application.queries.getAll;

import dev.juanleon.supermarket_inventory.modules.cash_register.application.dto.CashRegisterResponse;
import dev.juanleon.supermarket_inventory.share.mediator.IRequest;
import dev.juanleon.supermarket_inventory.share.utils.dto.PagedResponse;

public record GetAllCashRegisterQuery(
        Integer page,
        Integer size
) implements IRequest<PagedResponse<CashRegisterResponse>> { }
