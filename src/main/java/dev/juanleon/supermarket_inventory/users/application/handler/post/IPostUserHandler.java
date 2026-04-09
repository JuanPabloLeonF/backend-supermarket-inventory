package dev.juanleon.supermarket_inventory.users.application.handler.post;

import dev.juanleon.supermarket_inventory.users.application.dto.RequestUserDto;
import dev.juanleon.supermarket_inventory.users.application.dto.ResponseUserDto;

public interface IPostUserHandler {
    ResponseUserDto create(RequestUserDto requestUserDto);
}
