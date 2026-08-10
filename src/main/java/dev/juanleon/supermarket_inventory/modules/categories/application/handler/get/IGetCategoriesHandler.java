package dev.juanleon.supermarket_inventory.modules.categories.application.handler.get;

import dev.juanleon.supermarket_inventory.modules.categories.application.dto.ResponseCategoriesDto;
import dev.juanleon.supermarket_inventory.share.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.share.utils.dto.PaginationRequest;

import java.util.UUID;

public interface IGetCategoriesHandler  {
    ResponseCategoriesDto getById(UUID id);
    PagedResponse<ResponseCategoriesDto> getAll(PaginationRequest paginationRequest);
    PagedResponse<ResponseCategoriesDto> getByName(String name, PaginationRequest paginationRequest);
}
