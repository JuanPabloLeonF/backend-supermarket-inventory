package dev.juanleon.supermarket_inventory.modules.providers.application.queries.getBy;

import dev.juanleon.supermarket_inventory.modules.providers.application.dto.ResponseProviderDto;
import dev.juanleon.supermarket_inventory.share.mediator.IRequest;

import java.util.UUID;

public record GetByNameProviderQuery(
        String name
) implements IRequest<ResponseProviderDto> { }
