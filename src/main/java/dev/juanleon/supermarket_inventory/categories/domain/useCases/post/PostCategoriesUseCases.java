package dev.juanleon.supermarket_inventory.categories.domain.useCases.post;

import dev.juanleon.supermarket_inventory.categories.domain.models.CategoriesModel;
import dev.juanleon.supermarket_inventory.categories.domain.persistence.post.IPostCategoriesPersistence;
import dev.juanleon.supermarket_inventory.categories.domain.services.post.IPostCategoriesServices;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseModel;

public class PostCategoriesUseCases implements IPostCategoriesServices {

    private final IPostCategoriesPersistence iPostCategoriesPersistence;

    public PostCategoriesUseCases(IPostCategoriesPersistence iPostCategoriesPersistence) {
        this.iPostCategoriesPersistence = iPostCategoriesPersistence;
    }

    @Override
    public ResponseModel create(CategoriesModel categoriesModel) {
        String response = this.iPostCategoriesPersistence.create(categoriesModel);
        return new ResponseModel(response);
    }
}
