package dev.juanleon.supermarket_inventory.users.domain.useCases.get;

import dev.juanleon.supermarket_inventory.users.domain.models.UserModel;
import dev.juanleon.supermarket_inventory.users.domain.persistence.get.IGetUserPersistence;
import dev.juanleon.supermarket_inventory.users.infrastructure.outputs.exceptions.NotFoundUserException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetUserUseCaseTest {

    @Mock
    private IGetUserPersistence iGetUserPersistence;

    @InjectMocks
    private GetUserUseCase getUserUseCase;

    protected List<UserModel> userModelList;

    protected UUID id1 = UUID.randomUUID();
    protected UUID id2 = UUID.randomUUID();

    @BeforeEach
    void setUp() {
        this.userModelList = List.of(
                new UserModel(this.id1, "juan", "leon", "juan123@gmail.com", "1234567", "ADMIN", true, LocalDateTime.now(), LocalDateTime.now()),
                new UserModel(this.id2, "pipe", "leon", "pipe123@gmail.com", "123456789", "USER", false, LocalDateTime.now(), LocalDateTime.now())
        );
    }

    @Test
    void shouldReturnListOfUserModelWhenIsCalledMethodGetAll() {
        when(this.iGetUserPersistence.getAll()).thenReturn(this.userModelList);

        List<UserModel> response = this.getUserUseCase.getAll();

        assertEquals(2, response.size());
        assertEquals(this.userModelList, response);

        verify(this.iGetUserPersistence).getAll();
    }

    @Test
    void shouldReturnListOfEmptyWhenIsCalledMethodGetAll() {
        when(this.iGetUserPersistence.getAll()).thenReturn(Collections.emptyList());

        List<UserModel> response = this.getUserUseCase.getAll();

        assertTrue(response.isEmpty());

        verify(this.iGetUserPersistence).getAll();
    }

    @Test
    void shouldReturnUserModelWhenIsCalledMethodGetByIdWithParamId() {

        when(this.iGetUserPersistence.getById(this.id1)).thenReturn(this.userModelList.getFirst());

        UserModel response = this.getUserUseCase.getById(this.id1);

        assertNotNull(response);
        assertEquals(this.userModelList.getFirst(), response);

        verify(this.iGetUserPersistence).getById(this.id1);
    }

    @Test
    void shouldPropagateNotFoundUserExceptionWhenIsCalledMethodGetByIdWithParamNotExist() {
        UUID randomId = UUID.randomUUID();
        String message = "User not found with id: " + randomId;

        when(iGetUserPersistence.getById(randomId))
                .thenThrow(new NotFoundUserException(message));

        NotFoundUserException exception = assertThrows(NotFoundUserException.class, () -> {
            this.iGetUserPersistence.getById(randomId);
        });

        assertEquals(message, exception.getMessage());
        verify(iGetUserPersistence).getById(randomId);
    }

    @Test
    void shouldReturnListOfUserModelWhenIsCalledMethodGetByNameWithParamName() {

        String name = "pipe";

        List<UserModel> modelList = this.userModelList.stream()
                .filter(user -> Objects.equals(user.name(), name))
                .toList();

        when(this.iGetUserPersistence.getByName(name)).thenReturn(modelList);

        List<UserModel> response = this.getUserUseCase.getByName(name);

        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals(modelList, response);

        verify(this.iGetUserPersistence).getByName(name);
    }

    @Test
    void shouldReturnListOfEmptyWhenIsCalledMethodGetByNameWithParamNoExistisOrNull() {

        String name = "no existe";

        when(this.iGetUserPersistence.getByName(name)).thenReturn(Collections.emptyList());

        List<UserModel> response = this.getUserUseCase.getByName(name);

        assertTrue(response.isEmpty());

        verify(this.iGetUserPersistence).getByName(name);
    }

    @Test
    void shouldReturnListOfUserModelWhenIsCalledMethodGetByLastNameWithParamLastName() {

        String lastName = "leon";

        List<UserModel> modelList = this.userModelList.stream()
                .filter(user -> Objects.equals(user.lastName(), lastName))
                .toList();

        when(this.iGetUserPersistence.getByLastName(lastName)).thenReturn(modelList);

        List<UserModel> response = this.getUserUseCase.getByLastName(lastName);

        assertNotNull(response);
        assertEquals(2, response.size());
        assertEquals(modelList, response);

        verify(this.iGetUserPersistence).getByLastName(lastName);
    }

    @Test
    void shouldReturnListOfEmptyWhenIsCalledMethodGetByLastNameWithParamNoExistisOrNull() {

        String lastName = "no existe";

        when(this.iGetUserPersistence.getByLastName(lastName)).thenReturn(Collections.emptyList());

        List<UserModel> response = this.getUserUseCase.getByLastName(lastName);

        assertTrue(response.isEmpty());

        verify(this.iGetUserPersistence).getByLastName(lastName);
    }
}