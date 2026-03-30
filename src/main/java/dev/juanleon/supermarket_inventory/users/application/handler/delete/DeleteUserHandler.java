package dev.juanleon.supermarket_inventory.users.application.handler.delete;

import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.common.utils.mappers.IMapperResponseApp;
import dev.juanleon.supermarket_inventory.users.domain.services.delete.IDeleteUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteUserHandler implements IDeleteUserHandler{

    private final IDeleteUserService iDeleteUserService;
    private final IMapperResponseApp iMapperResponseApp;

    @Override
    public ResponseRequestDto deleteById(UUID id) {
        return this.iMapperResponseApp
                .toResponseRequestDto(this.iDeleteUserService.deleteById(id));
    }
}
