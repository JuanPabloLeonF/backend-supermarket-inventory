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
public class GetAllByPriceSaleProductsQueryHandler implements IRequestHandler<GetAllByPriceSaleProductsQuery, PagedResponse<ResponseProductDto>> {

    private final IGetProductsHandler iGetProductsHandler;

    @Override
    public PagedResponse<ResponseProductDto> handle(GetAllByPriceSaleProductsQuery request) {
        PaginationRequest data = PaginationRequest.builder()
                .page(request.page())
                .size(request.size())
                .build();
        return this.iGetProductsHandler.getByPriceSale(data, request.priceSale());
    }

    @Override
    public Class<GetAllByPriceSaleProductsQuery> getRequestType() {
        return GetAllByPriceSaleProductsQuery.class;
    }
}
