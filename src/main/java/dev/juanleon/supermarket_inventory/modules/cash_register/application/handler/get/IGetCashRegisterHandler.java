package dev.juanleon.supermarket_inventory.modules.cash_register.application.handler.get;

import dev.juanleon.supermarket_inventory.modules.cash_register.application.dto.CashRegisterResponse;
import dev.juanleon.supermarket_inventory.share.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.share.utils.dto.PaginationRequest;

import java.util.UUID;

public interface IGetCashRegisterHandler {
    CashRegisterResponse getById(UUID id);
    PagedResponse<CashRegisterResponse> getAll(PaginationRequest paginationRequest);
    PagedResponse<CashRegisterResponse> getByEmployeeId(UUID employeeId, PaginationRequest paginationRequest);
}
