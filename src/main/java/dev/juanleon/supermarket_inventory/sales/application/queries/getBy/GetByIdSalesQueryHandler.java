package dev.juanleon.supermarket_inventory.sales.application.queries.getBy;

import dev.juanleon.supermarket_inventory.common.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.sales.application.dto.ResponseSalesDto;
import dev.juanleon.supermarket_inventory.sales.application.handler.get.IGetSalesHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetByIdSalesQueryHandler implements IRequestHandler<GetByIdSalesQuery, ResponseSalesDto> {

    private final IGetSalesHandler iGetSalesHandler;

    @Override
    public ResponseSalesDto handle(GetByIdSalesQuery request) {
        return iGetSalesHandler.getById(request.id());
    }

    @Override
    public Class<GetByIdSalesQuery> getRequestType() {
        return GetByIdSalesQuery.class;
    }
}
