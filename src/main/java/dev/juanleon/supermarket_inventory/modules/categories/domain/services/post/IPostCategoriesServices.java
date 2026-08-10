package dev.juanleon.supermarket_inventory.modules.categories.domain.services.post;

import dev.juanleon.supermarket_inventory.modules.categories.domain.models.CategoriesModel;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseModel;

public interface IPostCategoriesServices {
    ResponseModel create(CategoriesModel categoriesModel);
}
