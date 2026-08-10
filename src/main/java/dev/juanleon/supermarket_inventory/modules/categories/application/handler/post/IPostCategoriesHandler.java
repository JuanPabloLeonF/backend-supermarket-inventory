package dev.juanleon.supermarket_inventory.modules.categories.application.handler.post;

import dev.juanleon.supermarket_inventory.modules.categories.application.dto.RequestCategoriesDto;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseRequestDto;

public interface IPostCategoriesHandler {
    ResponseRequestDto create(RequestCategoriesDto requestCategoriesDto);
}
