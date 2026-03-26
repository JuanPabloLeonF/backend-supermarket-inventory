package dev.juanleon.supermarket_inventory.users.infrastructure.outputs.database.adapters.get;

import dev.juanleon.supermarket_inventory.users.domain.models.UserModel;
import dev.juanleon.supermarket_inventory.users.infrastructure.outputs.database.entities.UserEntity;
import dev.juanleon.supermarket_inventory.users.infrastructure.outputs.database.mappers.IMapperUserInfrastructure;
import dev.juanleon.supermarket_inventory.users.infrastructure.outputs.database.repositories.IUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetUserAdapterTest {

    @Mock
    private IUserRepository iUserRepository;

    @Mock
    private IMapperUserInfrastructure iMapperUserInfrastructure;

    @InjectMocks
    private GetUserAdapter getUserAdapter;

    protected List<UserModel> userModelList;
    protected List<UserEntity> userEntityList;

    protected UUID id1 = UUID.randomUUID();
    protected UUID id2 = UUID.randomUUID();

    @BeforeEach
    void setUp() {

        this.userModelList = List.of(
             new UserModel(this.id1, "juan", "leon", "juan123@gmail.com", "1234567", "ADMIN", true, LocalDateTime.now(), LocalDateTime.now()),
             new UserModel(this.id2, "pipe", "leon", "pipe123@gmail.com", "123456789", "USER", false, LocalDateTime.now(), LocalDateTime.now())
        );

        this.userEntityList = List.of(
                new UserEntity(this.id1, "juan", "leon", "juan123@gmail.com", "1234567", "ADMIN", true, LocalDateTime.now(), LocalDateTime.now()),
                new UserEntity(this.id2, "pipe", "leon", "pipe123@gmail.com", "123456789", "USER", false, LocalDateTime.now(), LocalDateTime.now())
        );
    }

    @Test
    public void shouldReturnListOfUserModelWhenIsCalledMethodGetAll() {

        when(this.iUserRepository.findAll()).thenReturn(this.userEntityList);

        when(this.iMapperUserInfrastructure.toListModel(this.userEntityList))
                .thenReturn(this.userModelList);

        List<UserModel> response = this.getUserAdapter.getAll();

        assertNotNull(response);
        assertEquals(2, response.size());
        assertEquals(this.userModelList, response);
        assertEquals(this.id1, response.getFirst().id());

        verify(this.iUserRepository).findAll();
        verify(this.iMapperUserInfrastructure).toListModel(this.userEntityList);
    }
}