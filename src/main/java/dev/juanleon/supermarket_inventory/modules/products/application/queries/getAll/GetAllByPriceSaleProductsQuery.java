package dev.juanleon.supermarket_inventory.modules.products.application.queries.getAll;

import dev.juanleon.supermarket_inventory.share.mediator.IRequest;
import dev.juanleon.supermarket_inventory.share.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.modules.products.application.dto.ResponseProductDto;

import java.math.BigDecimal;

public record GetAllByPriceSaleProductsQuery(
        Integer page,
        Integer size,
        BigDecimal priceSale
) implements IRequest<PagedResponse<ResponseProductDto>> {
}
