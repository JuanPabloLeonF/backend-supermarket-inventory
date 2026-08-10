package dev.juanleon.supermarket_inventory.modules.products.application.queries.getAll;

import dev.juanleon.supermarket_inventory.share.mediator.IRequest;
import dev.juanleon.supermarket_inventory.share.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.modules.products.application.dto.ResponseProductDto;

public record GetAllByNameProductsQuery(
        Integer page,
        Integer size,
        String name
) implements IRequest<PagedResponse<ResponseProductDto>> {
}
