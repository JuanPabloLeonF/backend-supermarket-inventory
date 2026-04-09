package dev.juanleon.supermarket_inventory.employees.domain.services.get;

import dev.juanleon.supermarket_inventory.common.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.common.utils.dto.PaginationRequest;
import dev.juanleon.supermarket_inventory.employees.domain.models.EmployeeModel;

import java.time.LocalDateTime;
import java.util.UUID;

public interface IGetEmployeeService {
    PagedResponse<EmployeeModel> getAll(PaginationRequest paginationRequest);
    EmployeeModel getById(UUID id);
    PagedResponse<EmployeeModel> getByNameAndLastName(String name, String lastName, PaginationRequest paginationRequest);
    PagedResponse<EmployeeModel> getByPosition(String position, PaginationRequest paginationRequest);
    PagedResponse<EmployeeModel> getByHireDate(LocalDateTime hireDate, PaginationRequest paginationRequest);
    String getByIdUrlImage(UUID id);
}
