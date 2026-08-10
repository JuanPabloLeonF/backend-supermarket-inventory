package dev.juanleon.supermarket_inventory.modules.products.domain.ports;

import dev.juanleon.supermarket_inventory.modules.categories.domain.models.CategoriesModel;

import java.util.UUID;

public interface ICategoriesProviderProduct {
    CategoriesModel getCategoryById(UUID id);
}
