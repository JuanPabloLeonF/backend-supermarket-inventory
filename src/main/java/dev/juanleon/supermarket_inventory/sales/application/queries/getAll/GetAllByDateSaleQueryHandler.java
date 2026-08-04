package dev.juanleon.supermarket_inventory.sales.application.queries.getAll;

import dev.juanleon.supermarket_inventory.common.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.common.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.common.utils.dto.PaginationRequest;
import dev.juanleon.supermarket_inventory.sales.application.dto.ResponseSalesDto;
import dev.juanleon.supermarket_inventory.sales.application.handler.get.IGetSalesHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetAllByDateSaleQueryHandler implements IRequestHandler<GetAllByDateSaleQuery, PagedResponse<ResponseSalesDto>> {

    private final IGetSalesHandler iGetSalesHandler;

    @Override
    public PagedResponse<ResponseSalesDto> handle(GetAllByDateSaleQuery request) {
        PaginationRequest paginationRequest = PaginationRequest.builder()
                .page(request.page())
                .size(request.size())
                .build();
        return this.iGetSalesHandler.getAllByDateSale(request.dateSale(), paginationRequest);
    }

    @Override
    public Class<GetAllByDateSaleQuery> getRequestType() {
        return GetAllByDateSaleQuery.class;
    }
}
