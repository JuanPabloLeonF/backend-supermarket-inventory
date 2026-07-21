package dev.juanleon.supermarket_inventory.categories.application.queries.getAll;

import dev.juanleon.supermarket_inventory.categories.application.dto.ResponseCategoriesDto;
import dev.juanleon.supermarket_inventory.common.mediator.IRequest;
import dev.juanleon.supermarket_inventory.common.utils.dto.PagedResponse;

public record GetAllCategoriesQuery(Integer page, Integer size) implements IRequest<PagedResponse<ResponseCategoriesDto>> {
}
