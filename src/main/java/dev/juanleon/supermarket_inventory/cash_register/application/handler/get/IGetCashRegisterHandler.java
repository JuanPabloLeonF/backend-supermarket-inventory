package dev.juanleon.supermarket_inventory.cash_register.application.handler.get;

import dev.juanleon.supermarket_inventory.cash_register.application.dto.CashRegisterResponse;
import dev.juanleon.supermarket_inventory.common.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.common.utils.dto.PaginationRequest;

import java.util.UUID;

public interface IGetCashRegisterHandler {
    CashRegisterResponse getById(UUID id);
    PagedResponse<CashRegisterResponse> getAll(PaginationRequest paginationRequest);
    PagedResponse<CashRegisterResponse> getByEmployeeId(UUID employeeId, PaginationRequest paginationRequest);
}
