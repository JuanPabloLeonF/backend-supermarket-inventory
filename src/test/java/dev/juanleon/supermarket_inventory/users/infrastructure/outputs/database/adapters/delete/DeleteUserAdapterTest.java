package dev.juanleon.supermarket_inventory.users.infrastructure.outputs.database.adapters.delete;

import dev.juanleon.supermarket_inventory.users.infrastructure.outputs.database.entities.UserEntity;
import dev.juanleon.supermarket_inventory.users.infrastructure.outputs.database.repositories.IUserRepository;
import dev.juanleon.supermarket_inventory.users.infrastructure.outputs.exceptions.NotFoundUserException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DeleteUserAdapterTest {

    @Mock
    private IUserRepository iUserRepository;

    @InjectMocks
    private DeleteUserAdapter deleteUserAdapter;

    private UUID id;
    private UserEntity existingEntity;

    @BeforeEach
    void setUp() {
        this.id = UUID.randomUUID();
        this.existingEntity = UserEntity.builder()
                .id(this.id)
                .name("name")
                .lastName("lastName")
                .email("mail@test.com")
                .password("pass")
                .rol("USER")
                .isActive(true)
                .createdAt(LocalDateTime.now().minusDays(2).withNano(0))
                .updatedAt(LocalDateTime.now().minusDays(1).withNano(0))
                .build();
    }

    @Test
    void shouldDeleteUserAndReturnSuccessMessageWhenUserExists() {
        when(this.iUserRepository.findById(this.id)).thenReturn(Optional.of(this.existingEntity));
        doNothing().when(this.iUserRepository).deleteById(this.id);

        String response = this.deleteUserAdapter.deleteById(this.id);

        assertEquals("User deleted successfully by id: " + this.id, response);

        verify(this.iUserRepository).findById(this.id);
        verify(this.iUserRepository).deleteById(this.id);
        verifyNoMoreInteractions(this.iUserRepository);
    }

    @Test
    void shouldThrowNotFoundUserExceptionWhenUserDoesNotExist() {
        when(this.iUserRepository.findById(this.id)).thenReturn(Optional.empty());

        NotFoundUserException exception = assertThrows(
                NotFoundUserException.class,
                () -> this.deleteUserAdapter.deleteById(this.id)
        );

        assertEquals("User not found with id: " + this.id, exception.getMessage());

        verify(this.iUserRepository).findById(this.id);
        verifyNoMoreInteractions(this.iUserRepository);
    }
}

