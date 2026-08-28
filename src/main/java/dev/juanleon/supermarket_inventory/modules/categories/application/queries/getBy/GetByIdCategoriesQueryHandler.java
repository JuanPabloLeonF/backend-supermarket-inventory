package dev.juanleon.supermarket_inventory.modules.categories.application.queries.getBy;

import dev.juanleon.supermarket_inventory.modules.categories.application.dto.ResponseCategoriesDto;
import dev.juanleon.supermarket_inventory.modules.categories.application.mappers.IMapperCategoriesApplication;
import dev.juanleon.supermarket_inventory.modules.categories.domain.services.get.IGetCategoriesServices;
import dev.juanleon.supermarket_inventory.share.mediator.IRequestHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetByIdCategoriesQueryHandler implements IRequestHandler<GetByIdCategoriesQuery, ResponseCategoriesDto> {

    private final IGetCategoriesServices iGetCategoriesServices;
    private final IMapperCategoriesApplication iMapperCategoriesApplication;

    @Override
    public ResponseCategoriesDto handle(GetByIdCategoriesQuery request) {
        return this.iMapperCategoriesApplication.toDto(this.iGetCategoriesServices.getById(request.id()));
    }

    @Override
    public Class<GetByIdCategoriesQuery> getRequestType() {
        return GetByIdCategoriesQuery.class;
    }
}
