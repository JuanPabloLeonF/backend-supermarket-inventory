package dev.juanleon.supermarket_inventory.users.application.handler.get;

import dev.juanleon.supermarket_inventory.users.application.dto.ResponseUserDto;

import java.util.List;
import java.util.UUID;

public interface IGetUserHandler {
    public List<ResponseUserDto> getAll();
    public ResponseUserDto getById(UUID id);
    public List<ResponseUserDto> getByName(String name);
    public List<ResponseUserDto> getByLastName(String lastName);
}
