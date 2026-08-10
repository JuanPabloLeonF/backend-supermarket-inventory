package dev.juanleon.supermarket_inventory.modules.categories.domain.useCases.delete;

import dev.juanleon.supermarket_inventory.modules.categories.domain.persistence.delete.IDeleteCategoriesPersistence;
import dev.juanleon.supermarket_inventory.modules.categories.domain.services.delete.IDeleteCategoriesServices;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseModel;

import java.util.UUID;

public class DeleteCategoriesUseCases implements IDeleteCategoriesServices {

    private final IDeleteCategoriesPersistence iDeleteCategoriesPersistence;

    public DeleteCategoriesUseCases(IDeleteCategoriesPersistence iDeleteCategoriesPersistence) {
        this.iDeleteCategoriesPersistence = iDeleteCategoriesPersistence;
    }

    @Override
    public ResponseModel deleteById(UUID id) {
        String response = iDeleteCategoriesPersistence.deleteById(id);
        return new ResponseModel(response);
    }
}
