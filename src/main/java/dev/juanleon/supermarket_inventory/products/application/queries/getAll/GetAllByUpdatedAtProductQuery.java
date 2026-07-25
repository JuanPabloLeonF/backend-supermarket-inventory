package dev.juanleon.supermarket_inventory.products.application.queries.getAll;

import dev.juanleon.supermarket_inventory.common.mediator.IRequest;
import dev.juanleon.supermarket_inventory.common.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.products.application.dto.ResponseProductDto;

import java.time.LocalDate;

public record GetAllByUpdatedAtProductQuery(
        Integer page,
        Integer size,
        LocalDate updatedAt
) implements IRequest<PagedResponse<ResponseProductDto>> {
}
