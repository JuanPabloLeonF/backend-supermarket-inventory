package dev.juanleon.supermarket_inventory.employees.application.queries.getBy;

import dev.juanleon.supermarket_inventory.common.mediator.IRequest;
import dev.juanleon.supermarket_inventory.common.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.common.utils.dto.PaginationRequest;
import dev.juanleon.supermarket_inventory.employees.application.dto.responses.ResponseEmployeeDto;


public record GetByNameAndLastNameEmployeeQuery(
        String name,
        String lastName,
        PaginationRequest paginationRequest
) implements IRequest<PagedResponse<ResponseEmployeeDto>> {}
