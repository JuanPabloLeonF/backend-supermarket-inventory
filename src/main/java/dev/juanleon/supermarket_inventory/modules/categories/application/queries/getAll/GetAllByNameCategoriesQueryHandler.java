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
