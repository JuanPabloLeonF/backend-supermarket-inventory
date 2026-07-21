package dev.juanleon.supermarket_inventory.categories.application.handler.delete;

import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseRequestDto;

import java.util.UUID;

public interface IDeleteCategoriesHandler {
    ResponseRequestDto deleteById(UUID id);
}
