package dev.juanleon.supermarket_inventory.modules.products.application.queries.getAll;

import dev.juanleon.supermarket_inventory.share.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.share.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.share.utils.dto.PaginationRequest;
import dev.juanleon.supermarket_inventory.modules.products.application.dto.ResponseProductDto;
import dev.juanleon.supermarket_inventory.modules.products.application.handler.get.IGetProductsHandler;
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
