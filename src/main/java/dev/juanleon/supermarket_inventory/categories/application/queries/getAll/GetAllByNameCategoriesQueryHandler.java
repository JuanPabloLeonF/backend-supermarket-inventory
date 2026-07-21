package dev.juanleon.supermarket_inventory.categories.application.queries.getAll;

import dev.juanleon.supermarket_inventory.categories.application.dto.ResponseCategoriesDto;
import dev.juanleon.supermarket_inventory.categories.application.handler.get.IGetCategoriesHandler;
import dev.juanleon.supermarket_inventory.common.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.common.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.common.utils.dto.PaginationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetAllByNameCategoriesQueryHandler implements IRequestHandler<GetAllByNameCategoriesQuery, PagedResponse<ResponseCategoriesDto>> {

    private final IGetCategoriesHandler iGetCategoriesHandler;

    @Override
    public PagedResponse<ResponseCategoriesDto> handle(GetAllByNameCategoriesQuery request) {
        PaginationRequest data = PaginationRequest.builder()
                .page(request.page())
                .size(request.size())
                .build();
        return this.iGetCategoriesHandler.getByName(request.name(), data);
    }

    @Override
    public Class<GetAllByNameCategoriesQuery> getRequestType() {
        return GetAllByNameCategoriesQuery.class;
    }
}
