package dev.juanleon.supermarket_inventory.modules.categories.application.queries.getAll;

import dev.juanleon.supermarket_inventory.modules.categories.application.dto.ResponseCategoriesDto;
import dev.juanleon.supermarket_inventory.share.mediator.IRequest;
import dev.juanleon.supermarket_inventory.share.utils.dto.PagedResponse;

public record GetAllByNameCategoriesQuery(
        Integer page,
        Integer size,
        String name
) implements IRequest<PagedResponse<ResponseCategoriesDto>> {}
