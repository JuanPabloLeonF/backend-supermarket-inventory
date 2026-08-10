package dev.juanleon.supermarket_inventory.modules.categories.application.queries.getBy;

import dev.juanleon.supermarket_inventory.modules.categories.application.dto.ResponseCategoriesDto;
import dev.juanleon.supermarket_inventory.share.mediator.IRequest;

import java.util.UUID;

public record GetByIdCategoriesQuery(UUID id) implements IRequest<ResponseCategoriesDto> {
}
