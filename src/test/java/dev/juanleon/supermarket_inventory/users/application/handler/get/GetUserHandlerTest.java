package dev.juanleon.supermarket_inventory.users.application.handler.get;

import dev.juanleon.supermarket_inventory.users.application.dto.ResponseUserDto;
import dev.juanleon.supermarket_inventory.users.application.mappers.IMapperUserApplication;
import dev.juanleon.supermarket_inventory.users.domain.models.UserModel;
import dev.juanleon.supermarket_inventory.users.domain.services.get.IGetUserService;
import dev.juanleon.supermarket_inventory.users.infrastructure.outputs.exceptions.NotFoundUserException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
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

    @Test
    public void shouldReturnResponseUserDtoWhenIsCalledMethodGetByIdWithParamId() {

        UserModel userModel = this.userModelList.getFirst();
        ResponseUserDto userDto = this.responseUserDtoList.getFirst();

        when(this.iGetUserService.getById(this.id1)).thenReturn(userModel);
        when(this.iMapperUserApplication.toDto(userModel))
                .thenReturn(userDto);

        ResponseUserDto response = this.getUserHandler.getById(this.id1);

        assertNotNull(response);
        assertEquals(userDto, response);

        verify(this.iGetUserService).getById(this.id1);
        verify(this.iMapperUserApplication).toDto(userModel);
    }

    @Test
    public void shouldPropagateNotFoundUserExceptionWhenIsCalledMethodGetByIdWithParamNotExistOrNull() {

        UUID idNoExistis = UUID.randomUUID();
        String message = "User not found with id: " + idNoExistis;

        when(this.iGetUserService.getById(idNoExistis))
                .thenThrow(new NotFoundUserException(idNoExistis));

        NotFoundUserException exception = assertThrows(NotFoundUserException.class, () -> {
            this.getUserHandler.getById(idNoExistis);
        });

        assertEquals(message, exception.getMessage());
        assertEquals(NotFoundUserException.class, exception.getClass());

        verify(this.iGetUserService).getById(idNoExistis);
    }

    @Test
    public void shouldReturnListOfResponseUserDtoWhenIsCalledMethodGetByNameWithParamName() {

        String name = "juan";

        List<UserModel> modelList = this.userModelList.stream()
                .filter(user -> Objects.equals(user.name(), name))
                .toList();

        List<ResponseUserDto> userDtoList = this.responseUserDtoList.stream()
                .filter(user -> Objects.equals(user.getName(), name))
                .toList();

        when(this.iGetUserService.getByName(name)).thenReturn(modelList);
        when(this.iMapperUserApplication.toDtoList(modelList))
                .thenReturn(userDtoList);

        List<ResponseUserDto> response = this.getUserHandler.getByName(name);

        assertEquals(1, response.size());
        assertEquals(userDtoList, response);

        verify(this.iGetUserService).getByName(name);
        verify(this.iMapperUserApplication).toDtoList(modelList);
    }

    @Test
    public void shouldReturnListOfEmptyWhenIsCalledMethodGetByNameWithParamNoExistisOrNull() {

        String name = "no existe";

        when(this.iGetUserService.getByName(name)).thenReturn(Collections.emptyList());
        when(this.iMapperUserApplication.toDtoList(Collections.emptyList()))
                .thenReturn(Collections.emptyList());

        List<ResponseUserDto> response = this.getUserHandler.getByName(name);

        assertTrue(response.isEmpty());
        verify(this.iGetUserService).getByName(name);
        verify(this.iMapperUserApplication).toDtoList(Collections.emptyList());
    }

    @Test
    public void shouldReturnListOfResponseUserDtoWhenIsCalledMethodGetByLastNameWithParamLastName() {

        String lastName = "leon";

        List<UserModel> modelList = this.userModelList.stream()
                .filter(user -> Objects.equals(user.lastName(), lastName))
                .toList();

        List<ResponseUserDto> userDtoList = this.responseUserDtoList.stream()
                .filter(user -> Objects.equals(user.getLastName(), lastName))
                .toList();

        when(this.iGetUserService.getByLastName(lastName)).thenReturn(modelList);
        when(this.iMapperUserApplication.toDtoList(modelList))
                .thenReturn(userDtoList);

        List<ResponseUserDto> response = this.getUserHandler.getByLastName(lastName);

        assertEquals(2, response.size());
        assertEquals(userDtoList, response);

        verify(this.iGetUserService).getByLastName(lastName);
        verify(this.iMapperUserApplication).toDtoList(modelList);
    }

    @Test
    public void shouldReturnListOfEmptyWhenIsCalledMethodGetByLastNameWithParamNoExistisOrNull() {

        String lastName = "no existe";

        when(this.iGetUserService.getByLastName(lastName)).thenReturn(Collections.emptyList());
        when(this.iMapperUserApplication.toDtoList(Collections.emptyList()))
                .thenReturn(Collections.emptyList());

        List<ResponseUserDto> response = this.getUserHandler.getByLastName(lastName);

        assertTrue(response.isEmpty());
        verify(this.iGetUserService).getByLastName(lastName);
        verify(this.iMapperUserApplication).toDtoList(Collections.emptyList());
    }
}