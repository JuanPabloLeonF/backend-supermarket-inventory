package dev.juanleon.supermarket_inventory.sales.application.queries.getAll;

import dev.juanleon.supermarket_inventory.common.mediator.IRequest;
import dev.juanleon.supermarket_inventory.common.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.sales.application.dto.SalesResponseDTO;

import java.time.LocalDateTime;

public record GetAllByDateSaleQuery (
        LocalDateTime dateSale,
        Integer page,
        Integer size
) implements IRequest<PagedResponse<SalesResponseDTO>> {
}
