package dev.juanleon.supermarket_inventory.categories.domain.services.delete;

import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseModel;

import java.util.UUID;

public interface IDeleteCategoriesServices {
    ResponseModel deleteById(UUID id);
}
