package dev.juanleon.supermarket_inventory.categories.application.handler.get;

import dev.juanleon.supermarket_inventory.categories.application.dto.ResponseCategoriesDto;
import dev.juanleon.supermarket_inventory.categories.application.mappers.IMapperCategoriesApplication;
import dev.juanleon.supermarket_inventory.categories.domain.models.CategoriesModel;
import dev.juanleon.supermarket_inventory.categories.domain.services.get.IGetCategoriesServices;
import dev.juanleon.supermarket_inventory.common.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.common.utils.dto.PaginationRequest;
import dev.juanleon.supermarket_inventory.common.utils.mappers.IMapperPaginationApp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetCategoriesHandler implements IGetCategoriesHandler {

    private IGetCategoriesServices iGetCategoriesServices;
    private IMapperCategoriesApplication iMapperCategoriesApplication;
    private IMapperPaginationApp iMapperPaginationApp;

    @Override
    public ResponseCategoriesDto getById(UUID id) {
        return this.iMapperCategoriesApplication.toDto(this.iGetCategoriesServices.getById(id));
    }

    @Override
    public PagedResponse<ResponseCategoriesDto> getAll(PaginationRequest paginationRequest) {
        PagedResponse<CategoriesModel> categoriesModelPagedResponse = this.iGetCategoriesServices.getAll(paginationRequest);
        return this.iMapperPaginationApp.pageResponseToPageResponseTypeResponse(
                categoriesModelPagedResponse,
                this.iMapperCategoriesApplication::toDto
        );
    }

    @Override
    public PagedResponse<ResponseCategoriesDto> getByName(String name, PaginationRequest paginationRequest) {
        PagedResponse<CategoriesModel> categoriesModelPagedResponse = this.iGetCategoriesServices.getByName(paginationRequest, name);
        return this.iMapperPaginationApp.pageResponseToPageResponseTypeResponse(
                categoriesModelPagedResponse,
                this.iMapperCategoriesApplication::toDto
        );
    }
}
