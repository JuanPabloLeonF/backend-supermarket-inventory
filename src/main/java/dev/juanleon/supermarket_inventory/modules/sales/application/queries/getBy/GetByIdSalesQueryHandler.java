package dev.juanleon.supermarket_inventory.modules.sales.application.queries.getBy;

import dev.juanleon.supermarket_inventory.share.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.modules.sales.application.dto.ResponseSalesDto;
import dev.juanleon.supermarket_inventory.modules.sales.application.handler.get.IGetSalesHandler;
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
