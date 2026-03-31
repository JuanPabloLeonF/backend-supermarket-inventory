package dev.juanleon.supermarket_inventory.employees.domain.persistence.get;

import dev.juanleon.supermarket_inventory.common.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.common.utils.dto.PaginationRequest;
import dev.juanleon.supermarket_inventory.employees.domain.models.EmployeeModel;

import java.time.LocalDateTime;
import java.util.UUID;

public interface IGetEmployeePersistence {
    EmployeeModel getById(UUID id);
    PagedResponse<EmployeeModel> getByNameAndLastName(String name, String lastName, PaginationRequest paginationRequest);
    PagedResponse<EmployeeModel> getByPosition(String position, PaginationRequest paginationRequest);
    PagedResponse<EmployeeModel> getByHireDate(LocalDateTime hireDate, PaginationRequest paginationRequest);
}
