package dev.juanleon.supermarket_inventory.products.application.handler.update;

import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.products.application.dto.RequestProductUpdateDto;

import java.util.UUID;

public interface IUpdateProductHandler {
    ResponseRequestDto update(RequestProductUpdateDto requestProductUpdateDto);
    ResponseRequestDto updateActive(UUID productId, Boolean active);
}
