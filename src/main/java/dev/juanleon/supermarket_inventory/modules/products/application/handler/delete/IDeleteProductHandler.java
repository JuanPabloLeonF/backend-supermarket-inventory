package dev.juanleon.supermarket_inventory.modules.products.application.handler.delete;

import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseRequestDto;

import java.util.UUID;

public interface IDeleteProductHandler {
    ResponseRequestDto deleteById(UUID id);
}
