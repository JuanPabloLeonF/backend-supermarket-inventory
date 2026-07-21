package dev.juanleon.supermarket_inventory.categories.application.queries.getBy;

import dev.juanleon.supermarket_inventory.categories.application.dto.ResponseCategoriesDto;
import dev.juanleon.supermarket_inventory.categories.application.handler.get.IGetCategoriesHandler;
import dev.juanleon.supermarket_inventory.common.mediator.IRequestHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetByIdCategoriesQueryHandler implements IRequestHandler<GetByIdCategoriesQuery, ResponseCategoriesDto> {

    private final IGetCategoriesHandler iGetCategoriesHandler;

    @Override
    public ResponseCategoriesDto handle(GetByIdCategoriesQuery request) {
        return this.iGetCategoriesHandler.getById(request.id());
    }

    @Override
    public Class<GetByIdCategoriesQuery> getRequestType() {
        return GetByIdCategoriesQuery.class;
    }
}
