package dev.juanleon.supermarket_inventory.users.application.handler.get;

import dev.juanleon.supermarket_inventory.users.application.dto.ResponseUserDto;
import dev.juanleon.supermarket_inventory.users.application.mappers.IMapperUserApplication;
import dev.juanleon.supermarket_inventory.users.domain.models.UserModel;
import dev.juanleon.supermarket_inventory.users.domain.services.get.IGetUserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetUserHandlerTest {

    @Mock
    private IGetUserService iGetUserService;

    @Mock
    private IMapperUserApplication iMapperUserApplication;

    @InjectMocks
    private GetUserHandler getUserHandler;

    protected List<ResponseUserDto> responseUserDtoList;
    protected List<UserModel> userModelList;

    protected UUID id1 = UUID.randomUUID();
    protected UUID id2 = UUID.randomUUID();

    @BeforeEach
    void setUp() {
        this.responseUserDtoList = List.of(
                new ResponseUserDto(this.id1, "juan", "leon", "juan123@gmail.com", "1234567", "ADMIN", true, LocalDateTime.now(), LocalDateTime.now()),
                new ResponseUserDto(this.id2, "pipe", "leon", "pipe123@gmail.com", "123456789", "USER", false, LocalDateTime.now(), LocalDateTime.now())
        );

        this.userModelList = List.of(
                new UserModel(this.id1, "juan", "leon", "juan123@gmail.com", "1234567", "ADMIN", true, LocalDateTime.now(), LocalDateTime.now()),
                new UserModel(this.id2, "pipe", "leon", "pipe123@gmail.com", "123456789", "USER", false, LocalDateTime.now(), LocalDateTime.now())
        );
    }

    @Test
    public void shouldReturnListOfResponseUserDtoWhenIsCalledMethodGetAll() {

        when(this.iGetUserService.getAll()).thenReturn(this.userModelList);
        when(this.iMapperUserApplication.toDtoList(this.userModelList))
                .thenReturn(this.responseUserDtoList);

        List<ResponseUserDto> response = this.getUserHandler.getAll();

        assertEquals(2, response.size());
        assertEquals(this.responseUserDtoList, response);

        verify(this.iGetUserService).getAll();
        verify(this.iMapperUserApplication).toDtoList(this.userModelList);
    }

    @Test
    public void shouldReturnListOfEmptyWhenIsCalledMethodGetAll() {

        when(this.iGetUserService.getAll()).thenReturn(Collections.emptyList());
        when(this.iMapperUserApplication.toDtoList(Collections.emptyList()))
                .thenReturn(Collections.emptyList());

        List<ResponseUserDto> response = this.getUserHandler.getAll();

        assertTrue(response.isEmpty());
        verify(this.iGetUserService).getAll();
        verify(this.iMapperUserApplication).toDtoList(Collections.emptyList());
    }
}