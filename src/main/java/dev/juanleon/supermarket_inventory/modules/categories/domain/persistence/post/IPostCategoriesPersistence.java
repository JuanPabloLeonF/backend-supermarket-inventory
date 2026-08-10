package dev.juanleon.supermarket_inventory.modules.categories.domain.persistence.post;

import dev.juanleon.supermarket_inventory.modules.categories.domain.models.CategoriesModel;

public interface IPostCategoriesPersistence {
    String create(CategoriesModel categoriesModel);
}
