package dev.juanleon.supermarket_inventory.modules.products.application.queries.getBy;

import dev.juanleon.supermarket_inventory.share.mediator.IRequest;
import dev.juanleon.supermarket_inventory.modules.products.application.dto.ResponseProductDto;

import java.util.UUID;

public record GetByIdProductsQuery(UUID id) implements IRequest<ResponseProductDto> {
}
