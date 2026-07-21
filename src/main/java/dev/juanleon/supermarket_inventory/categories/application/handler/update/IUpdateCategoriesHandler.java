package dev.juanleon.supermarket_inventory.categories.application.handler.update;

import dev.juanleon.supermarket_inventory.categories.application.dto.RequestUpdateCategoriesDto;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseRequestDto;

public interface IUpdateCategoriesHandler {
    ResponseRequestDto updateById(RequestUpdateCategoriesDto requestUpdateCategoriesDto);
}
