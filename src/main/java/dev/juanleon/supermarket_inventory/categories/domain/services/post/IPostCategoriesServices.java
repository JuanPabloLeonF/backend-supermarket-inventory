package dev.juanleon.supermarket_inventory.categories.domain.services.post;

import dev.juanleon.supermarket_inventory.categories.domain.models.CategoriesModel;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseModel;

public interface IPostCategoriesServices {
    ResponseModel create(CategoriesModel categoriesModel);
}
