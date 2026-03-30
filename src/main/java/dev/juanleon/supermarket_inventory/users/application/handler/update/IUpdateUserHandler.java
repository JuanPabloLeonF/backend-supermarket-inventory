package dev.juanleon.supermarket_inventory.users.application.handler.update;

import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.users.application.dto.RequestUpdateUserDto;

public interface IUpdateUserHandler {
    public ResponseRequestDto updateById(RequestUpdateUserDto requestUpdateUserDto);
}
