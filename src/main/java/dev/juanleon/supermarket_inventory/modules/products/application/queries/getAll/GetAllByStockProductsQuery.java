package dev.juanleon.supermarket_inventory.modules.products.application.queries.getAll;

import dev.juanleon.supermarket_inventory.share.mediator.IRequest;
import dev.juanleon.supermarket_inventory.share.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.modules.products.application.dto.ResponseProductDto;

public record GetAllByStockProductsQuery(
        Integer page,
        Integer size,
        Integer stock
) implements IRequest<PagedResponse<ResponseProductDto>> {
}
