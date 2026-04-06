package dev.juanleon.supermarket_inventory.employees.application.queries.getAll;

import dev.juanleon.supermarket_inventory.common.mediator.IRequest;
import dev.juanleon.supermarket_inventory.common.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.common.utils.dto.PaginationRequest;
import dev.juanleon.supermarket_inventory.employees.application.dto.ResponseEmployeeDto;

public record GetAllEmployeeQuery(PaginationRequest paginationRequest) implements IRequest<PagedResponse<ResponseEmployeeDto>> {
}
