package dev.juanleon.supermarket_inventory.users.application.handler.update;

import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.common.utils.mappers.IMapperResponseApp;
import dev.juanleon.supermarket_inventory.users.application.dto.RequestUpdateUserDto;
import dev.juanleon.supermarket_inventory.users.application.mappers.IMapperUserApplication;
import dev.juanleon.supermarket_inventory.users.domain.models.ResponseModel;
import dev.juanleon.supermarket_inventory.users.domain.models.UserModel;
import dev.juanleon.supermarket_inventory.users.domain.services.update.IUpdateUserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.UUID;

import static dev.juanleon.supermarket_inventory.common.utils.enums.MessagesApp.USER_UPDATE_SUCCESSFULLY_BY_ID;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UpdateUserHandlerTest {

    @Mock
    private IUpdateUserService iUpdateUserService;
    @Mock
    private IMapperUserApplication iMapperUserApplication;
    @Mock
    private IMapperResponseApp iMapperResponseApp;
    @InjectMocks
    private UpdateUserHandler updateUserHandler;

    protected UserModel userModel;
    protected UUID id1 = UUID.randomUUID();
    protected ResponseModel responseModel;
    protected ResponseRequestDto responseRequestDto;
    protected RequestUpdateUserDto requestUpdateUserDto;

    @BeforeEach
    void setUp() {
        this.userModel = new UserModel(
                this.id1,
                "fabian",
                "contreras",
                "fabian@gmail.com",
                "12345678",
                "USER",
                false,
                LocalDateTime.now().withNano(0),
                LocalDateTime.now().withNano(0)
        );

        this.responseModel = new ResponseModel(USER_UPDATE_SUCCESSFULLY_BY_ID.format(this.userModel.id()));

        this.responseRequestDto = ResponseRequestDto
                .builder()
                .message(USER_UPDATE_SUCCESSFULLY_BY_ID.format(this.userModel.id()))
                .date(LocalDateTime.now())
                .build();

        this.requestUpdateUserDto = RequestUpdateUserDto
                .builder()
                .id(this.userModel.id())
                .name(this.userModel.name())
                .lastName(this.userModel.lastName())
                .isActive(this.userModel.isActive())
                .build();
    }

    @Test
    void shouldReturnResponseRequestDtoWhenUpdateByIdIsCalled() {

        when(this.iMapperUserApplication.toModel(this.requestUpdateUserDto))
                .thenReturn(this.userModel);

        when(this.iUpdateUserService.updateById(this.userModel))
                .thenReturn(this.responseModel);

        when(this.iMapperResponseApp.toResponseRequestDto(this.responseModel))
                .thenReturn(this.responseRequestDto);

        ResponseRequestDto response = this.updateUserHandler.updateById(this.requestUpdateUserDto);

        assertNotNull(response);
        assertNotNull(response.getDate());
        assertEquals(this.responseRequestDto.getMessage(), response.getMessage());

        verify(this.iMapperUserApplication).toModel(this.requestUpdateUserDto);
        verify(this.iUpdateUserService).updateById(this.userModel);
        verify(this.iMapperResponseApp).toResponseRequestDto(this.responseModel);
    }

}