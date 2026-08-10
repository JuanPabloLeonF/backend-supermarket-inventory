package dev.juanleon.supermarket_inventory.modules.categories.domain.useCases.get;

import dev.juanleon.supermarket_inventory.modules.categories.domain.models.CategoriesModel;
import dev.juanleon.supermarket_inventory.modules.categories.domain.persistence.get.IGetCategoriesPersistence;
import dev.juanleon.supermarket_inventory.modules.categories.domain.services.get.IGetCategoriesServices;
import dev.juanleon.supermarket_inventory.share.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.share.utils.dto.PaginationRequest;

import java.util.UUID;

public class GetCategoriesUseCases implements IGetCategoriesServices {

    private final IGetCategoriesPersistence iGetCategoriesPersistence;

    public GetCategoriesUseCases(IGetCategoriesPersistence iGetCategoriesPersistence) {
        this.iGetCategoriesPersistence = iGetCategoriesPersistence;
    }

    @Override
    public CategoriesModel getById(UUID id) {
        return this.iGetCategoriesPersistence.getById(id);
    }

    @Override
    public PagedResponse<CategoriesModel> getAll(PaginationRequest paginationRequest) {
        return this.iGetCategoriesPersistence.getAll(paginationRequest);
    }

    @Override
    public PagedResponse<CategoriesModel> getByName(PaginationRequest paginationRequest, String name) {
        return this.iGetCategoriesPersistence.getByName(paginationRequest, name);
    }
}
