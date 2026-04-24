package dev.juanleon.supermarket_inventory.cash_register.application.queries.getBy;

import dev.juanleon.supermarket_inventory.cash_register.application.dto.CashRegisterResponse;
import dev.juanleon.supermarket_inventory.common.mediator.IRequest;
import dev.juanleon.supermarket_inventory.common.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.common.utils.dto.PaginationRequest;

import java.util.UUID;

public record GetByEmployeeIdCashRegisterQuery(
        UUID employeeId,
        PaginationRequest paginationRequest
) implements IRequest<PagedResponse<CashRegisterResponse>> { }
