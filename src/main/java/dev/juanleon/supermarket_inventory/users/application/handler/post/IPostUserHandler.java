package dev.juanleon.supermarket_inventory.users.application.handler.post;

import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.users.application.dto.RequestUserDto;

public interface IPostUserHandler {
    public ResponseRequestDto create(RequestUserDto requestUserDto);
}
