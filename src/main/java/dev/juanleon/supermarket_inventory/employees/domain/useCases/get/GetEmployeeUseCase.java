package dev.juanleon.supermarket_inventory.employees.domain.useCases.get;

import dev.juanleon.supermarket_inventory.common.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.common.utils.dto.PaginationRequest;
import dev.juanleon.supermarket_inventory.employees.domain.models.EmployeeModel;
import dev.juanleon.supermarket_inventory.employees.domain.persistence.get.IGetEmployeePersistence;
import dev.juanleon.supermarket_inventory.employees.domain.services.get.IGetEmployeeService;

import java.time.LocalDateTime;
import java.util.UUID;

public class GetEmployeeUseCase implements IGetEmployeeService {

    private final IGetEmployeePersistence iGetEmployeePersistence;

    public GetEmployeeUseCase(IGetEmployeePersistence iGetEmployeePersistence) {
        this.iGetEmployeePersistence = iGetEmployeePersistence;
    }

    @Override
    public EmployeeModel getById(UUID id) {
        return this.iGetEmployeePersistence.getById(id);
    }

    @Override
    public PagedResponse<EmployeeModel> getByNameAndLastName(String name, String lastName, PaginationRequest paginationRequest) {
        return this.iGetEmployeePersistence.getByNameAndLastName(name, lastName, paginationRequest);
    }

    @Override
    public PagedResponse<EmployeeModel> getByPosition(String position, PaginationRequest paginationRequest) {
        return this.iGetEmployeePersistence.getByPosition(position, paginationRequest);
    }

    @Override
    public PagedResponse<EmployeeModel> getByHireDate(LocalDateTime hireDate, PaginationRequest paginationRequest) {
        return this.iGetEmployeePersistence.getByHireDate(hireDate, paginationRequest);
    }
}
