package dev.juanleon.supermarket_inventory.modules.categories.application.handler.update;

import dev.juanleon.supermarket_inventory.modules.categories.application.dto.RequestUpdateCategoriesDto;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseRequestDto;

public interface IUpdateCategoriesHandler {
    ResponseRequestDto updateById(RequestUpdateCategoriesDto requestUpdateCategoriesDto);
}
