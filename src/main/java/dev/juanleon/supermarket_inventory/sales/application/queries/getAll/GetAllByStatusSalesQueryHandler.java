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
public class GetAllByStatusSalesQueryHandler implements IRequestHandler<GetAllByStatusSalesQuery, PagedResponse<ResponseSalesDto>> {

    private final IGetSalesHandler iGetSalesHandler;

    @Override
    public PagedResponse<ResponseSalesDto> handle(GetAllByStatusSalesQuery request) {
        PaginationRequest paginationRequest = PaginationRequest.builder()
                .page(request.page())
                .size(request.size())
                .build();
        return iGetSalesHandler.getAllByStatus(request.status(), paginationRequest);
    }

    @Override
    public Class<GetAllByStatusSalesQuery> getRequestType() {
        return GetAllByStatusSalesQuery.class;
    }
}
