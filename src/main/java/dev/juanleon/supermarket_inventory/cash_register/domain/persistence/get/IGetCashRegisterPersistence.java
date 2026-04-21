package dev.juanleon.supermarket_inventory.cash_register.domain.persistence.get;

import dev.juanleon.supermarket_inventory.cash_register.domain.models.CashRegisterModel;
import dev.juanleon.supermarket_inventory.common.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.common.utils.dto.PaginationRequest;

import java.util.UUID;

public interface IGetCashRegisterPersistence {
    CashRegisterModel getById(UUID id);
    PagedResponse<CashRegisterModel> getAll(PaginationRequest paginationRequest);
    PagedResponse<CashRegisterModel> getByEmployeeId(UUID employeeId, PaginationRequest paginationRequest);
}
