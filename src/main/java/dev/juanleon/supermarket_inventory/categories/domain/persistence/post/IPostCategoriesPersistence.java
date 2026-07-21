package dev.juanleon.supermarket_inventory.categories.domain.persistence.post;

import dev.juanleon.supermarket_inventory.categories.domain.models.CategoriesModel;

public interface IPostCategoriesPersistence {
    String create(CategoriesModel categoriesModel);
}
