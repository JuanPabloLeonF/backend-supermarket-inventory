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
public class GetAllByCategoriesProductsQueryHandler implements IRequestHandler<GetAllByCategoriesProductsQuery, PagedResponse<ResponseProductDto>> {

    private final IGetProductsHandler iGetProductsHandler;

    @Override
    public PagedResponse<ResponseProductDto> handle(GetAllByCategoriesProductsQuery request) {
        PaginationRequest data = PaginationRequest.builder()
                .page(request.page())
                .size(request.size())
                .build();
        return this.iGetProductsHandler.getByCategories(data, request.categoriesName());
    }

    @Override
    public Class<GetAllByCategoriesProductsQuery> getRequestType() {
        return GetAllByCategoriesProductsQuery.class;
    }
}
