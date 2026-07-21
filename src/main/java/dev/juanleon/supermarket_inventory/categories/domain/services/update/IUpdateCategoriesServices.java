package dev.juanleon.supermarket_inventory.categories.domain.services.update;

import dev.juanleon.supermarket_inventory.categories.domain.models.CategoriesModel;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseModel;

public interface IUpdateCategoriesServices {
    ResponseModel updateById(CategoriesModel categoriesModel);
}
