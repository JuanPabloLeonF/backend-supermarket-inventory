package dev.juanleon.supermarket_inventory.modules.purchases.application.queries.getAll;

import dev.juanleon.supermarket_inventory.modules.purchases.application.dto.ResponsePurchaseDto;
import dev.juanleon.supermarket_inventory.share.mediator.IRequest;
import dev.juanleon.supermarket_inventory.share.utils.dto.PagedResponse;

import java.util.UUID;

public record GetAllByIdProviderPurchaseQuery(
        UUID idProvider,
        Integer page,
        Integer size
) implements IRequest<PagedResponse<ResponsePurchaseDto>> {}
