package dev.juanleon.supermarket_inventory.modules.categories.domain.services.update;

import dev.juanleon.supermarket_inventory.modules.categories.domain.models.CategoriesModel;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseModel;

public interface IUpdateCategoriesServices {
    ResponseModel updateById(CategoriesModel categoriesModel);
}
