package dev.juanleon.supermarket_inventory.categories.domain.persistence.get;

import dev.juanleon.supermarket_inventory.categories.domain.models.CategoriesModel;
import dev.juanleon.supermarket_inventory.common.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.common.utils.dto.PaginationRequest;

import java.util.UUID;

public interface IGetCategoriesPersistence {

    CategoriesModel getById(UUID id);
    PagedResponse<CategoriesModel> getAll(PaginationRequest paginationRequest);
    PagedResponse<CategoriesModel> getByName(PaginationRequest paginationRequest, String name);
}
