package dev.juanleon.supermarket_inventory.users.application.handler.post;

import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.common.utils.enums.Roles;
import dev.juanleon.supermarket_inventory.common.utils.mappers.IMapperResponseApp;
import dev.juanleon.supermarket_inventory.users.application.dto.RequestUserDto;
import dev.juanleon.supermarket_inventory.users.application.mappers.IMapperUserApplication;
import dev.juanleon.supermarket_inventory.users.domain.models.ResponseModel;
import dev.juanleon.supermarket_inventory.users.domain.models.UserModel;
import dev.juanleon.supermarket_inventory.users.domain.services.post.IPostUserService;
import dev.juanleon.supermarket_inventory.users.infrastructure.outputs.exceptions.NoCreateUserOnDatabaseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PostUserHandlerTest {

    @Mock
    private IPostUserService iPostUserService;

    @Mock
    private IMapperUserApplication iMapperUserApplication;

    @Mock
    private IMapperResponseApp iMapperResponseApp;

    @InjectMocks
    private PostUserHandler postUserHandler;

    protected RequestUserDto requestUserDto;
    protected UserModel userModel;
    protected ResponseModel responseModel;
    protected ResponseRequestDto responseRequestDto;

    protected UUID id1 = UUID.randomUUID();

    @BeforeEach
    void setUp() {
        this.requestUserDto = RequestUserDto.builder()
                .name("juan")
                .lastName("leon")
                .email("juan123@gmail.com")
                .password("Abcd1234@")
                .rol(Roles.ADMIN)
                .isActive(true)
                .build();

        this.userModel = new UserModel(
                this.id1,
                "juan",
                "leon",
                "juan123@gmail.com",
                "Abcd1234@",
                "ADMIN",
                true,
                LocalDateTime.now(),
                LocalDateTime.now()
        );

        LocalDateTime fixedDate = LocalDateTime.now().withNano(0);
        this.responseModel = new ResponseModel("User created successfully", fixedDate);
        this.responseRequestDto = ResponseRequestDto.builder()
                .message("User created successfully")
                .date(fixedDate)
                .build();
    }

    @Test
    void shouldReturnResponseRequestDtoWhenIsCalledMethodCreate() {

        when(this.iMapperUserApplication.toModel(this.requestUserDto)).thenReturn(this.userModel);
        when(this.iPostUserService.create(this.userModel)).thenReturn(this.responseModel);
        when(this.iMapperResponseApp.toResponseRequestDto(this.responseModel))
                .thenReturn(this.responseRequestDto);

        ResponseRequestDto response = this.postUserHandler.create(this.requestUserDto);

        assertNotNull(response);
        assertEquals(this.responseRequestDto, response);

        verify(this.iMapperUserApplication).toModel(this.requestUserDto);
        verify(this.iPostUserService).create(this.userModel);
        verify(this.iMapperResponseApp).toResponseRequestDto(this.responseModel);
    }
}
