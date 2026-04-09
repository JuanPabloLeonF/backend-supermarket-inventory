package dev.juanleon.supermarket_inventory.users.application.handler.get;

import dev.juanleon.supermarket_inventory.users.application.dto.ResponseUserDto;

import java.util.List;
import java.util.UUID;

public interface IGetUserHandler {
    List<ResponseUserDto> getAll();
    ResponseUserDto getById(UUID id);
    List<ResponseUserDto> getByName(String name);
    List<ResponseUserDto> getByLastName(String lastName);
}
