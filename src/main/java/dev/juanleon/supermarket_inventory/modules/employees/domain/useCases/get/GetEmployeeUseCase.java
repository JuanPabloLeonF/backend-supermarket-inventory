package dev.juanleon.supermarket_inventory.modules.employees.domain.useCases.get;

import dev.juanleon.supermarket_inventory.share.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.share.utils.dto.PaginationRequest;
import dev.juanleon.supermarket_inventory.modules.employees.domain.models.EmployeeModel;
import dev.juanleon.supermarket_inventory.modules.employees.domain.persistence.get.IGetEmployeePersistence;
import dev.juanleon.supermarket_inventory.modules.employees.domain.services.get.IGetEmployeeService;

import java.time.LocalDate;
import java.util.UUID;

public class GetEmployeeUseCase implements IGetEmployeeService {

    private final IGetEmployeePersistence iGetEmployeePersistence;

    public GetEmployeeUseCase(IGetEmployeePersistence iGetEmployeePersistence) {
        this.iGetEmployeePersistence = iGetEmployeePersistence;
    }

    @Override
    public PagedResponse<EmployeeModel> getAll(PaginationRequest paginationRequest) {
        return this.iGetEmployeePersistence.getAll(paginationRequest);
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
    public PagedResponse<EmployeeModel> getByHireDate(LocalDate hireDate, PaginationRequest paginationRequest) {
        return this.iGetEmployeePersistence.getByHireDate(hireDate, paginationRequest);
    }

    @Override
    public String getByIdUrlImage(UUID id) {
        return this.iGetEmployeePersistence.getByIdUrlImage(id);
    }
}
