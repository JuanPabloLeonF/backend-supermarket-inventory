package dev.juanleon.supermarket_inventory.modules.categories.application.handler.delete;

import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseRequestDto;

import java.util.UUID;

public interface IDeleteCategoriesHandler {
    ResponseRequestDto deleteById(UUID id);
}
