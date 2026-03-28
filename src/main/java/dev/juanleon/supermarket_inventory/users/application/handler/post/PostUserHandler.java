package dev.juanleon.supermarket_inventory.users.application.handler.post;

import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.common.utils.mappers.IMapperResponseApp;
import dev.juanleon.supermarket_inventory.users.application.dto.RequestUserDto;
import dev.juanleon.supermarket_inventory.users.application.mappers.IMapperUserApplication;
import dev.juanleon.supermarket_inventory.users.domain.models.ResponseModel;
import dev.juanleon.supermarket_inventory.users.domain.services.post.IPostUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostUserHandler implements IPostUserHandler {

    private final IPostUserService iPostUserService;
    private final IMapperUserApplication iMapperUserApplication;
    private final IMapperResponseApp iMapperResponseApp;

    @Override
    public ResponseRequestDto create(RequestUserDto requestUserDto) {
        ResponseModel responseModel = this.iPostUserService.create(this.iMapperUserApplication.toModel(requestUserDto));
        return this.iMapperResponseApp.toResponseRequestDto(responseModel);
    }
}
