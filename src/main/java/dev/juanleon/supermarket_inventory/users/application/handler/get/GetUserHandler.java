package dev.juanleon.supermarket_inventory.users.application.handler.get;

import dev.juanleon.supermarket_inventory.users.application.dto.ResponseUserDto;
import dev.juanleon.supermarket_inventory.users.application.mappers.IMapperUserApplication;
import dev.juanleon.supermarket_inventory.users.domain.services.get.IGetUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetUserHandler implements IGetUserHandler {

    private final IGetUserService iGetUserService;
    private final IMapperUserApplication iMapperUserApplication;

    @Override
    public List<ResponseUserDto> getAll() {
        return this.iMapperUserApplication.
                toDtoList(this.iGetUserService.getAll());
    }

    @Override
    public ResponseUserDto getById(UUID id) {
        return this.iMapperUserApplication
                .toDto(this.iGetUserService.getById(id));
    }

    @Override
    public List<ResponseUserDto> getByName(String name) {
        return this.iMapperUserApplication
                .toDtoList(this.iGetUserService.getByName(name));
    }

    @Override
    public List<ResponseUserDto> getByLastName(String lastName) {
        return this.iMapperUserApplication
                .toDtoList(this.iGetUserService.getByLastName(lastName));
    }
}
