package dev.juanleon.supermarket_inventory.users.application.handler.update;

import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.common.utils.mappers.IMapperResponseApp;
import dev.juanleon.supermarket_inventory.users.application.dto.RequestUpdateUserDto;
import dev.juanleon.supermarket_inventory.users.application.mappers.IMapperUserApplication;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.users.domain.models.UserModel;
import dev.juanleon.supermarket_inventory.users.domain.services.update.IUpdateUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class UpdateUserHandler implements IUpdateUserHandler {

    private final IUpdateUserService iUpdateUserService;
    private final IMapperUserApplication iMapperUserApplication;
    private final IMapperResponseApp iMapperResponseApp;

    @Transactional
    @Override
    public ResponseRequestDto updateById(RequestUpdateUserDto requestUpdateUserDto) {
        UserModel model = this.iMapperUserApplication.toModel(requestUpdateUserDto);
        ResponseModel responseModel = this.iUpdateUserService.updateById(model);
        return this.iMapperResponseApp.toResponseRequestDto(responseModel);
    }
}
