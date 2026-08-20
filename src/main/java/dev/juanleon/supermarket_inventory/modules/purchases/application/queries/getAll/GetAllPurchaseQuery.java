package dev.juanleon.supermarket_inventory.modules.purchases.application.queries.getAll;

import dev.juanleon.supermarket_inventory.modules.purchases.application.dto.ResponsePurchaseDto;
import dev.juanleon.supermarket_inventory.share.mediator.IRequest;
import dev.juanleon.supermarket_inventory.share.utils.dto.PagedResponse;

public record GetAllPurchaseQuery(
        Integer page,
        Integer size
) implements IRequest<PagedResponse<ResponsePurchaseDto>> {
}
