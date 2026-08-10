package dev.juanleon.supermarket_inventory.modules.sales.application.queries.getAll;

import dev.juanleon.supermarket_inventory.share.mediator.IRequest;
import dev.juanleon.supermarket_inventory.share.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.modules.sales.application.dto.ResponseSalesDto;

public record GetAllByMethodPaymentSalesQuery (
        String methodPayment,
        Integer page,
        Integer size
) implements IRequest<PagedResponse<ResponseSalesDto>> {}
