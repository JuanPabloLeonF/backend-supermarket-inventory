package dev.juanleon.supermarket_inventory.products.application.queries.getAll;

import dev.juanleon.supermarket_inventory.common.mediator.IRequest;
import dev.juanleon.supermarket_inventory.common.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.products.application.dto.ResponseProductDto;

public record GetAllByCategoriesProductsQuery(
        Integer page,
        Integer size,
        String categoriesName
) implements IRequest<PagedResponse<ResponseProductDto>> {
}
