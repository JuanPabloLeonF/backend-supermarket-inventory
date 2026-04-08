package dev.juanleon.supermarket_inventory.employees.application.handler.get;

import dev.juanleon.supermarket_inventory.common.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.common.utils.dto.PaginationRequest;
import dev.juanleon.supermarket_inventory.employees.application.dto.responses.ResponseEmployeeDto;

import java.time.LocalDateTime;
import java.util.UUID;

public interface IGetEmployeeHandler {
    PagedResponse<ResponseEmployeeDto> getAll(PaginationRequest paginationRequest);
    ResponseEmployeeDto getById(UUID id);
    PagedResponse<ResponseEmployeeDto> getByNameAndLastName(String name, String lastName, PaginationRequest paginationRequest);
    PagedResponse<ResponseEmployeeDto> getByPosition(String position, PaginationRequest paginationRequest);
    PagedResponse<ResponseEmployeeDto> getByHireDate(LocalDateTime hireDate, PaginationRequest paginationRequest);
}
