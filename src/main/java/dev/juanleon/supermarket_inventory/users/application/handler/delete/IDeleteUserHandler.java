package dev.juanleon.supermarket_inventory.users.application.handler.delete;

import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseRequestDto;

import java.util.UUID;

public interface IDeleteUserHandler {
    ResponseRequestDto deleteById(UUID id);
}
