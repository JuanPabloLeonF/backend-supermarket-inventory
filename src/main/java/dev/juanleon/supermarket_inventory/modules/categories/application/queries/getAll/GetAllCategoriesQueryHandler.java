package dev.juanleon.supermarket_inventory.modules.categories.application.queries.getAll;

import dev.juanleon.supermarket_inventory.modules.categories.application.dto.ResponseCategoriesDto;
import dev.juanleon.supermarket_inventory.modules.categories.application.handler.get.IGetCategoriesHandler;
import dev.juanleon.supermarket_inventory.share.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.share.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.share.utils.dto.PaginationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetAllCategoriesQueryHandler implements IRequestHandler<GetAllCategoriesQuery, PagedResponse<ResponseCategoriesDto>> {

    private final IGetCategoriesHandler iGetCategoriesHandler;

    @Override
    public PagedResponse<ResponseCategoriesDto> handle(GetAllCategoriesQuery request) {
        PaginationRequest data = PaginationRequest.builder()
                .page(request.page())
                .size(request.size())
                .build();
        return this.iGetCategoriesHandler.getAll(data);
    }

    @Override
    public Class<GetAllCategoriesQuery> getRequestType() {
        return GetAllCategoriesQuery.class;
    }
}
