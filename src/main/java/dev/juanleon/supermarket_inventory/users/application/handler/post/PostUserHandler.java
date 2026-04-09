package dev.juanleon.supermarket_inventory.users.application.handler.post;

import dev.juanleon.supermarket_inventory.common.utils.mappers.IMapperResponseApp;
import dev.juanleon.supermarket_inventory.users.application.dto.RequestUserDto;
import dev.juanleon.supermarket_inventory.users.application.dto.ResponseUserDto;
import dev.juanleon.supermarket_inventory.users.application.mappers.IMapperUserApplication;
import dev.juanleon.supermarket_inventory.users.domain.models.UserModel;
import dev.juanleon.supermarket_inventory.users.domain.services.post.IPostUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostUserHandler implements IPostUserHandler {

    private final IPostUserService iPostUserService;
    private final IMapperUserApplication iMapperUserApplication;
    private final IMapperResponseApp iMapperResponseApp;

    @Transactional
    @Override
    public ResponseUserDto create(RequestUserDto requestUserDto) {
        UserModel userModel = this.iMapperUserApplication.toModel(requestUserDto);
        UserModel userModelCreated = this.iPostUserService.create(userModel);
        return this.iMapperUserApplication.toDto(userModelCreated);
    }
}
