package dev.juanleon.supermarket_inventory.modules.products.application.queries.getAll;

import dev.juanleon.supermarket_inventory.share.mediator.IRequest;
import dev.juanleon.supermarket_inventory.share.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.modules.products.application.dto.ResponseProductDto;

import java.time.LocalDate;

public record GetAllByUpdatedAtProductQuery(
        Integer page,
        Integer size,
        LocalDate updatedAt
) implements IRequest<PagedResponse<ResponseProductDto>> {
}
