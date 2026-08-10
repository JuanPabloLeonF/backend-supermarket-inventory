package dev.juanleon.supermarket_inventory.modules.categories.domain.persistence.update;

import dev.juanleon.supermarket_inventory.modules.categories.domain.models.CategoriesModel;

public interface IUpdateCategoriesPersistence {
    String updateById(CategoriesModel categoriesModel);
}
