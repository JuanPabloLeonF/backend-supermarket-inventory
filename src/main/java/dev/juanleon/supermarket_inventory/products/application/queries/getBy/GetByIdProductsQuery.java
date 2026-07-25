package dev.juanleon.supermarket_inventory.products.application.queries.getBy;

import dev.juanleon.supermarket_inventory.common.mediator.IRequest;
import dev.juanleon.supermarket_inventory.products.application.dto.ResponseProductDto;

import java.util.UUID;

public record GetByIdProductsQuery(UUID id) implements IRequest<ResponseProductDto> {
}
