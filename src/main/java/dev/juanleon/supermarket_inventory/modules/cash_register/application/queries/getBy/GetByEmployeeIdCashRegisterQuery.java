package dev.juanleon.supermarket_inventory.modules.cash_register.application.queries.getBy;

import dev.juanleon.supermarket_inventory.modules.cash_register.application.dto.CashRegisterResponse;
import dev.juanleon.supermarket_inventory.share.mediator.IRequest;
import dev.juanleon.supermarket_inventory.share.utils.dto.PagedResponse;

import java.util.UUID;

public record GetByEmployeeIdCashRegisterQuery(
        UUID employeeId,
        Integer page,
        Integer size
) implements IRequest<PagedResponse<CashRegisterResponse>> { }
