package dev.juanleon.supermarket_inventory.products.application.handler.delete;

import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseRequestDto;

import java.util.UUID;

public interface IDeleteProductHandler {
    ResponseRequestDto deleteById(UUID id);
}
