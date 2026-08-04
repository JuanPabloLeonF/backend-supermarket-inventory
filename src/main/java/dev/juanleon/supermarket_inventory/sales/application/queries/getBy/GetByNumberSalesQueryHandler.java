package dev.juanleon.supermarket_inventory.sales.application.queries.getBy;

import dev.juanleon.supermarket_inventory.common.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.sales.application.dto.ResponseSalesDto;
import dev.juanleon.supermarket_inventory.sales.application.handler.get.IGetSalesHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetByNumberSalesQueryHandler implements IRequestHandler<GetByNumberSalesQuery, ResponseSalesDto> {

    private final IGetSalesHandler iGetSalesHandler;

    @Override
    public ResponseSalesDto handle(GetByNumberSalesQuery request) {
        return iGetSalesHandler.getByNumberSale(request.numberSale());
    }

    @Override
    public Class<GetByNumberSalesQuery> getRequestType() {
        return GetByNumberSalesQuery.class;
    }
}
