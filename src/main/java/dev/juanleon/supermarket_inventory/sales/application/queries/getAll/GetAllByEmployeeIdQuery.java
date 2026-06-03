package dev.juanleon.supermarket_inventory.sales.application.queries.getAll;

import dev.juanleon.supermarket_inventory.common.mediator.IRequest;
import dev.juanleon.supermarket_inventory.common.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.sales.application.dto.SalesResponseDTO;

import java.util.UUID;

public record GetAllByEmployeeIdQuery (
        UUID employeeId,
        Integer page,
        Integer size
) implements IRequest<PagedResponse<SalesResponseDTO>> {
}
