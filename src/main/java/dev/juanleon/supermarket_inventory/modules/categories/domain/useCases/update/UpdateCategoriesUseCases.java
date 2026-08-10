package dev.juanleon.supermarket_inventory.modules.categories.domain.useCases.update;

import dev.juanleon.supermarket_inventory.modules.categories.domain.models.CategoriesModel;
import dev.juanleon.supermarket_inventory.modules.categories.domain.persistence.update.IUpdateCategoriesPersistence;
import dev.juanleon.supermarket_inventory.modules.categories.domain.services.update.IUpdateCategoriesServices;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseModel;

public class UpdateCategoriesUseCases implements IUpdateCategoriesServices {

    private final IUpdateCategoriesPersistence iUpdateCategoriesPersistence;

    public UpdateCategoriesUseCases(IUpdateCategoriesPersistence iUpdateCategoriesPersistence) {
        this.iUpdateCategoriesPersistence = iUpdateCategoriesPersistence;
    }

    @Override
    public ResponseModel updateById(CategoriesModel categoriesModel) {
        String response = iUpdateCategoriesPersistence.updateById(categoriesModel);
        return new ResponseModel(response);
    }
}
