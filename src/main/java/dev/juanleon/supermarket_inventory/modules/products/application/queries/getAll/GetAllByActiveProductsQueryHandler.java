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
public class GetAllByActiveProductsQueryHandler implements IRequestHandler<GetAllByActiveProductsQuery, PagedResponse<ResponseProductDto>> {

    private final IGetProductsHandler iGetProductsHandler;

    @Override
    public PagedResponse<ResponseProductDto> handle(GetAllByActiveProductsQuery request) {
        PaginationRequest data = PaginationRequest.builder()
                .page(request.page())
                .size(request.size())
                .build();
        return this.iGetProductsHandler.getByActive(data, request.active());
    }

    @Override
    public Class<GetAllByActiveProductsQuery> getRequestType() {
        return GetAllByActiveProductsQuery.class;
    }
}
