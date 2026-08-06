package dev.juanleon.supermarket_inventory.products.domain.ports;

import dev.juanleon.supermarket_inventory.categories.domain.models.CategoriesModel;

import java.util.UUID;

public interface ICategoriesProviderProduct {
    CategoriesModel getCategoryById(UUID id);
}
