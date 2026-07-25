package dev.juanleon.supermarket_inventory.products.application.queries.getBy;

import dev.juanleon.supermarket_inventory.common.mediator.IRequest;
import dev.juanleon.supermarket_inventory.products.application.dto.ResponseProductDto;

public record GetByCodeProductsQuery(String code) implements IRequest<ResponseProductDto> {
}
