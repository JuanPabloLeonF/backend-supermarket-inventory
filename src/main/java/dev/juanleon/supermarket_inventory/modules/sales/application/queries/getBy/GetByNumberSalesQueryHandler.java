package dev.juanleon.supermarket_inventory.modules.sales.application.queries.getBy;

import dev.juanleon.supermarket_inventory.modules.sales.application.mappers.IMapperSalesApplication;
import dev.juanleon.supermarket_inventory.modules.sales.domain.services.get.IGetSalesServices;
import dev.juanleon.supermarket_inventory.share.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.modules.sales.application.dto.ResponseSalesDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetByNumberSalesQueryHandler implements IRequestHandler<GetByNumberSalesQuery, ResponseSalesDto> {

    private final IGetSalesServices iGetSalesServices;
    private final IMapperSalesApplication iMapperSalesApplication;

    @Override
    public ResponseSalesDto handle(GetByNumberSalesQuery request) {
        return this.iMapperSalesApplication.toResponse(
                this.iGetSalesServices.getByNumberSale(request.numberSale())
        );
    }

    @Override
    public Class<GetByNumberSalesQuery> getRequestType() {
        return GetByNumberSalesQuery.class;
    }
}
