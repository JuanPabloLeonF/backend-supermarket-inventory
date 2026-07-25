package dev.juanleon.supermarket_inventory.products.application.queries.getAll;

import dev.juanleon.supermarket_inventory.common.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.common.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.common.utils.dto.PaginationRequest;
import dev.juanleon.supermarket_inventory.products.application.dto.ResponseProductDto;
import dev.juanleon.supermarket_inventory.products.application.handler.get.IGetProductsHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetAllByStockProductsQueryHandler implements IRequestHandler<GetAllByStockProductsQuery, PagedResponse<ResponseProductDto>> {

    private final IGetProductsHandler iGetProductsHandler;

    @Override
    public PagedResponse<ResponseProductDto> handle(GetAllByStockProductsQuery request) {
        PaginationRequest data = PaginationRequest.builder()
                .page(request.page())
                .size(request.size())
                .build();
        return this.iGetProductsHandler.getByStock(data, request.stock());
    }

    @Override
    public Class<GetAllByStockProductsQuery> getRequestType() {
        return GetAllByStockProductsQuery.class;
    }
}
