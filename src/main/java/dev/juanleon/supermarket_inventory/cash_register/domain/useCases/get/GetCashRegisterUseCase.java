package dev.juanleon.supermarket_inventory.cash_register.domain.useCases.get;

import dev.juanleon.supermarket_inventory.cash_register.domain.models.CashRegisterModel;
import dev.juanleon.supermarket_inventory.cash_register.domain.persistence.get.IGetCashRegisterPersistence;
import dev.juanleon.supermarket_inventory.cash_register.domain.services.get.IGetCashRegisterService;
import dev.juanleon.supermarket_inventory.common.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.common.utils.dto.PaginationRequest;

import java.util.UUID;

public class GetCashRegisterUseCase implements IGetCashRegisterService {

    private final IGetCashRegisterPersistence iGetCashRegisterPersistence;

    public GetCashRegisterUseCase(IGetCashRegisterPersistence iGetCashRegisterPersistence) {
        this.iGetCashRegisterPersistence = iGetCashRegisterPersistence;
    }

    @Override
    public CashRegisterModel getById(UUID id) {
        return this.iGetCashRegisterPersistence.getById(id);
    }

    @Override
    public PagedResponse<CashRegisterModel> getAll(PaginationRequest paginationRequest) {
        return this.iGetCashRegisterPersistence.getAll(paginationRequest);
    }

    @Override
    public PagedResponse<CashRegisterModel> getByEmployeeId(UUID employeeId, PaginationRequest paginationRequest) {
        return this.iGetCashRegisterPersistence.getByEmployeeId(employeeId, paginationRequest);
    }
}
