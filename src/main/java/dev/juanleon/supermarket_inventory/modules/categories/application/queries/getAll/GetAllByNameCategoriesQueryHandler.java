package dev.juanleon.supermarket_inventory.modules.categories.application.queries.getAll;

import dev.juanleon.supermarket_inventory.modules.categories.application.dto.ResponseCategoriesDto;
import dev.juanleon.supermarket_inventory.modules.categories.application.mappers.IMapperCategoriesApplication;
import dev.juanleon.supermarket_inventory.modules.categories.domain.models.CategoriesModel;
import dev.juanleon.supermarket_inventory.modules.categories.domain.services.get.IGetCategoriesServices;
import dev.juanleon.supermarket_inventory.share.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.share.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.share.utils.dto.PaginationRequest;
import dev.juanleon.supermarket_inventory.share.utils.mappers.IMapperPaginationApp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetAllByNameCategoriesQueryHandler implements IRequestHandler<GetAllByNameCategoriesQuery, PagedResponse<ResponseCategoriesDto>> {

    private final IGetCategoriesServices iGetCategoriesServices;
    private final IMapperCategoriesApplication iMapperCategoriesApplication;
    private final IMapperPaginationApp iMapperPaginationApp;

    @Override
    public PagedResponse<ResponseCategoriesDto> handle(GetAllByNameCategoriesQuery request) {
        PaginationRequest data = PaginationRequest.builder()
                .page(request.page())
                .size(request.size())
                .build();

        PagedResponse<CategoriesModel> categoriesModelPagedResponse = this.iGetCategoriesServices.getByName(data, request.name());

        return this.iMapperPaginationApp.pageResponseToPageResponseTypeResponse(
                categoriesModelPagedResponse,
                this.iMapperCategoriesApplication::toDto
        );
    }

    @Override
    public Class<GetAllByNameCategoriesQuery> getRequestType() {
        return GetAllByNameCategoriesQuery.class;
    }
}
