package dev.juanleon.supermarket_inventory.modules.providers.application.queries.getAll;

import dev.juanleon.supermarket_inventory.modules.providers.application.dto.ResponseProviderDto;
import dev.juanleon.supermarket_inventory.share.mediator.IRequest;
import dev.juanleon.supermarket_inventory.share.utils.dto.PagedResponse;

public record GetAllProviderQuery(
        Integer page,
        Integer size
) implements IRequest<PagedResponse<ResponseProviderDto>> { }
