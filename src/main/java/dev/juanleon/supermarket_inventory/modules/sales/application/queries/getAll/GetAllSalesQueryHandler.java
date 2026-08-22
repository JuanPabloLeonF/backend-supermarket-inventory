package dev.juanleon.supermarket_inventory.modules.sales.application.queries.getAll;

import dev.juanleon.supermarket_inventory.modules.sales.application.mappers.IMapperSalesApplication;
import dev.juanleon.supermarket_inventory.modules.sales.domain.services.get.IGetSalesServices;
import dev.juanleon.supermarket_inventory.share.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.share.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.share.utils.dto.PaginationRequest;
import dev.juanleon.supermarket_inventory.modules.sales.application.dto.ResponseSalesDto;
import dev.juanleon.supermarket_inventory.share.utils.mappers.IMapperPaginationApp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetAllSalesQueryHandler implements IRequestHandler<GetAllSalesQuery, PagedResponse<ResponseSalesDto>> {

    private final IGetSalesServices iGetSalesServices;
    private final IMapperSalesApplication iMapperSalesApplication;
    private final IMapperPaginationApp iMapperPaginationApp;

    @Override
    public PagedResponse<ResponseSalesDto> handle(GetAllSalesQuery request) {
        PaginationRequest paginationRequest = PaginationRequest.builder()
                .page(request.page())
                .size(request.size())
                .build();
        return this.iMapperPaginationApp.pageResponseToPageResponseTypeResponse(
                this.iGetSalesServices.getAll(paginationRequest),
                this.iMapperSalesApplication::toResponse
        );
    }

    @Override
    public Class<GetAllSalesQuery> getRequestType() {
        return GetAllSalesQuery.class;
    }
}
