package dev.juanleon.supermarket_inventory.modules.providers.application.handler.delete;

import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseRequestDto;

import java.util.UUID;

public interface IDeleteProviderHandler {
    ResponseRequestDto deleteById(UUID id);
}
