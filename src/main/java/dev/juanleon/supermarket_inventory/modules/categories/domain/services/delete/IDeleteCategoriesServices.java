package dev.juanleon.supermarket_inventory.modules.categories.domain.services.delete;

import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseModel;

import java.util.UUID;

public interface IDeleteCategoriesServices {
    ResponseModel deleteById(UUID id);
}
