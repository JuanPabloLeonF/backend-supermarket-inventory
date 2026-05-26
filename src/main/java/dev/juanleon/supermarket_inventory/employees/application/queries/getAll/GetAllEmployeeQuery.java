package dev.juanleon.supermarket_inventory.employees.application.queries.getAll;

import dev.juanleon.supermarket_inventory.common.mediator.IRequest;
import dev.juanleon.supermarket_inventory.common.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.employees.application.dto.responses.ResponseEmployeeDto;

public record GetAllEmployeeQuery(Integer page, Integer size) implements IRequest<PagedResponse<ResponseEmployeeDto>> {
}
