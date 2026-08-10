package dev.juanleon.supermarket_inventory.modules.employees.application.queries.getBy;

import dev.juanleon.supermarket_inventory.share.mediator.IRequest;
import dev.juanleon.supermarket_inventory.share.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.modules.employees.application.dto.responses.ResponseEmployeeDto;

public record GetByPositionQuery(
        String position,
        Integer page,
        Integer size
) implements IRequest<PagedResponse<ResponseEmployeeDto>> {}
