package dev.juanleon.supermarket_inventory.products.application.queries.getAll;

import dev.juanleon.supermarket_inventory.common.mediator.IRequest;
import dev.juanleon.supermarket_inventory.common.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.products.application.dto.ResponseProductDto;

import java.math.BigDecimal;

public record GetAllByPriceSaleProductsQuery(
        Integer page,
        Integer size,
        BigDecimal priceSale
) implements IRequest<PagedResponse<ResponseProductDto>> {
}
