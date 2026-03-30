package dev.juanleon.supermarket_inventory.users.infrastructure.outputs.database.adapters.update;

import dev.juanleon.supermarket_inventory.users.domain.models.UserModel;
import dev.juanleon.supermarket_inventory.users.infrastructure.outputs.database.entities.UserEntity;
import dev.juanleon.supermarket_inventory.users.infrastructure.outputs.database.repositories.IUserRepository;
import dev.juanleon.supermarket_inventory.users.infrastructure.outputs.exceptions.NoUpdateUserByIdException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import static dev.juanleon.supermarket_inventory.common.utils.enums.MessagesApp.USER_NOT_FOUND_BY_ID;
import static dev.juanleon.supermarket_inventory.common.utils.enums.MessagesApp.USER_UPDATE_SUCCESSFULLY_BY_ID;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UpdateUserAdapterTest {

    @Mock
    private IUserRepository iUserRepository;

    @InjectMocks
    private UpdateUserAdapter updateUserAdapter;

    protected UserModel userModel;
    protected UserEntity userEntity;
    protected UUID id1 = UUID.randomUUID();

    @BeforeEach
    void setUp() {
        this.userModel = new UserModel(
                this.id1,
                "fabian",
                "contreras",
                null,
                null,
                null,
                false,
                null,
                null
        );

        this.userEntity = UserEntity.builder()
                .id(this.id1)
                .name("juan")
                .lastName("leon")
                .email("juan123@gmail.com")
                .password("1234567")
                .rol("ADMIN")
                .isActive(true)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }

    @Test
    void shouldReturnSuccessMessageWhenUserExistsAndIsUpdated() {

        String messageSuccess = USER_UPDATE_SUCCESSFULLY_BY_ID.format(this.userModel.id());

        when(this.iUserRepository.findById(this.userModel.id()))
                .thenReturn(Optional.of(this.userEntity));

        String result = updateUserAdapter.updateById(this.userModel);

        assertNotNull(result);
        assertEquals(messageSuccess, result);
        assertEquals(this.userModel.name(), this.userEntity.getName());
        assertEquals(this.userModel.lastName(), this.userEntity.getLastName());
        assertFalse(this.userEntity.getIsActive());

        verify(this.iUserRepository).save(this.userEntity);
    }

    @Test
    void shouldThrowNoUpdateUserByIdExceptionWhenUserDoesNotExist() {

        String messageError = USER_NOT_FOUND_BY_ID.format(this.userModel.id());

        when(this.iUserRepository.findById(this.userModel.id()))
                .thenReturn(Optional.empty());

        NoUpdateUserByIdException exception = assertThrows(NoUpdateUserByIdException.class, () -> {
            this.updateUserAdapter.updateById(this.userModel);
        });

        assertNotNull(exception);
        assertEquals(messageError, exception.getMessage());
        assertEquals(NoUpdateUserByIdException.class.getSimpleName(), exception.getClass().getSimpleName());

        verify(this.iUserRepository, never()).save(any(UserEntity.class));
    }
}