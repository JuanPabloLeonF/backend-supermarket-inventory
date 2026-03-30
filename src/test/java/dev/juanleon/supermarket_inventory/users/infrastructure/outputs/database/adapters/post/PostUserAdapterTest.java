package dev.juanleon.supermarket_inventory.users.infrastructure.outputs.database.adapters.post;

import dev.juanleon.supermarket_inventory.users.domain.models.UserModel;
import dev.juanleon.supermarket_inventory.users.infrastructure.outputs.database.entities.UserEntity;
import dev.juanleon.supermarket_inventory.users.infrastructure.outputs.database.mappers.IMapperUserInfrastructure;
import dev.juanleon.supermarket_inventory.users.infrastructure.outputs.database.repositories.IUserRepository;
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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PostUserAdapterTest {

    @Mock
    private IUserRepository iUserRepository;

    @Mock
    private IMapperUserInfrastructure iMapperUserInfrastructure;

    @InjectMocks
    private PostUserAdapter postUserAdapter;

    protected UserModel userModel;
    protected UserEntity userEntity;
    protected UUID id1 = UUID.randomUUID();

    @BeforeEach
    void setUp() {
        this.userModel = new UserModel(
                null,
                "juan",
                "leon",
                "juan123@gmail.com",
                "1234567",
                "ADMIN",
                true,
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
    void shouldReturnSuccessMessageWhenIsCalledMethodCreateWithSavedId() {

        when(this.iMapperUserInfrastructure.toEntity(this.userModel)).thenReturn(this.userEntity);

        when(this.iUserRepository.save(any(UserEntity.class))).thenAnswer(invocation -> {
            return invocation.getArgument(0);
        });

        String response = this.postUserAdapter.create(this.userModel);

        assertTrue(response.contains("User created successfully with id: "));

        verify(this.iMapperUserInfrastructure).toEntity(this.userModel);
        verify(this.iUserRepository).save(any(UserEntity.class));
    }

    @Test
    void shouldReturnThrowNoCreateUserOnDatabaseExceptionWhenIsCalledMethodCreateWithSavedIdNull() {

        UserEntity entityWithoutId = UserEntity.builder()
                .id(null)
                .name("juan")
                .lastName("leon")
                .email("juan123@gmail.com")
                .password("1234567")
                .rol("ADMIN")
                .isActive(true)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        when(this.iMapperUserInfrastructure.toEntity(this.userModel)).thenReturn(entityWithoutId);
        when(this.iUserRepository.save(entityWithoutId)).thenReturn(entityWithoutId);

        NoCreateUserOnDatabaseException exception = assertThrows(
                NoCreateUserOnDatabaseException.class,
                () -> this.postUserAdapter.create(this.userModel)
        );

        assertTrue(exception.getMessage().startsWith("User not created on database with data: "));

        verify(this.iMapperUserInfrastructure).toEntity(this.userModel);
        verify(this.iUserRepository).save(entityWithoutId);
    }
}
