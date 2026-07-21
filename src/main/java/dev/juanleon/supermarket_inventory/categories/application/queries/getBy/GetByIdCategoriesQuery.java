package dev.juanleon.supermarket_inventory.categories.application.queries.getBy;

import dev.juanleon.supermarket_inventory.categories.application.dto.ResponseCategoriesDto;
import dev.juanleon.supermarket_inventory.common.mediator.IRequest;

import java.util.UUID;

public record GetByIdCategoriesQuery(UUID id) implements IRequest<ResponseCategoriesDto> {
}
