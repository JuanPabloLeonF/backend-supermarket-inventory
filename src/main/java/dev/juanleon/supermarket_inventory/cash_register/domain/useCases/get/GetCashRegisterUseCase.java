package dev.juanleon.supermarket_inventory.cash_register.domain.useCases.get;

import dev.juanleon.supermarket_inventory.cash_register.domain.models.CashRegisterModel;
import dev.juanleon.supermarket_inventory.cash_register.domain.persistence.get.IGetCashRegisterPersistence;
import dev.juanleon.supermarket_inventory.cash_register.domain.services.get.IGetCashRegisterService;
import dev.juanleon.supermarket_inventory.common.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.common.utils.dto.PaginationRequest;
import dev.juanleon.supermarket_inventory.employees.domain.services.get.IGetEmployeeService;

import java.util.UUID;

public class GetCashRegisterUseCase implements IGetCashRegisterService {

    private final IGetCashRegisterPersistence iGetCashRegisterPersistence;
    private final IGetEmployeeService iGetEmployeeService;

    public GetCashRegisterUseCase(IGetCashRegisterPersistence iGetCashRegisterPersistence, IGetEmployeeService iGetEmployeeService) {
        this.iGetCashRegisterPersistence = iGetCashRegisterPersistence;
        this.iGetEmployeeService = iGetEmployeeService;
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
        this.iGetEmployeeService.getById(employeeId);
        return this.iGetCashRegisterPersistence.getByEmployeeId(employeeId, paginationRequest);
    }
}
