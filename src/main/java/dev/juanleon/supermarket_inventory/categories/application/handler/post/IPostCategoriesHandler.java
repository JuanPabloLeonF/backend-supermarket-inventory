package dev.juanleon.supermarket_inventory.categories.application.handler.post;

import dev.juanleon.supermarket_inventory.categories.application.dto.RequestCategoriesDto;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseRequestDto;

public interface IPostCategoriesHandler {
    ResponseRequestDto create(RequestCategoriesDto requestCategoriesDto);
}
