package dev.juanleon.supermarket_inventory.cash_register.application.queries.getAll;

import dev.juanleon.supermarket_inventory.cash_register.application.dto.CashRegisterResponse;
import dev.juanleon.supermarket_inventory.common.mediator.IRequest;
import dev.juanleon.supermarket_inventory.common.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.common.utils.dto.PaginationRequest;

public record GetAllCashRegisterQuery(PaginationRequest paginationRequest) implements IRequest<PagedResponse<CashRegisterResponse>> { }
