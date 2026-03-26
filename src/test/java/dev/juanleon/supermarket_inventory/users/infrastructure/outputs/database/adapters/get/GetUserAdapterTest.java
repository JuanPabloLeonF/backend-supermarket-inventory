package dev.juanleon.supermarket_inventory.users.infrastructure.outputs.database.adapters.get;

import dev.juanleon.supermarket_inventory.users.domain.models.UserModel;
import dev.juanleon.supermarket_inventory.users.infrastructure.outputs.database.entities.UserEntity;
import dev.juanleon.supermarket_inventory.users.infrastructure.outputs.database.mappers.IMapperUserInfrastructure;
import dev.juanleon.supermarket_inventory.users.infrastructure.outputs.database.repositories.IUserRepository;
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
import static org.mockito.Mockito.*;

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

    @Test
    public void shouldReturnListOfEmptyWhenIsCalledMethodGetAll() {

        List<UserEntity> entityListEmpty = new ArrayList<UserEntity>();
        List<UserModel> modelListEmpty = new ArrayList<UserModel>();

        when(this.iUserRepository.findAll()).thenReturn(entityListEmpty);

        when(this.iMapperUserInfrastructure.toListModel(entityListEmpty))
                .thenReturn(modelListEmpty);

        List<UserModel> response = this.getUserAdapter.getAll();

        assertNotNull(response);
        assertEquals(0, response.size());
        assertEquals(modelListEmpty, response);

        verify(this.iUserRepository).findAll();
        verify(this.iMapperUserInfrastructure).toListModel(entityListEmpty);
    }

    @Test
    public void shouldReturnUserModelWhenIsCalledMethodGetByIdWithParamId() {

        when(this.iUserRepository.findById(this.id1))
                .thenReturn(Optional.of(this.userEntityList.getFirst()));

        when(this.iMapperUserInfrastructure.toModel(this.userEntityList.getFirst()))
                .thenReturn(this.userModelList.getFirst());

        UserModel response = this.getUserAdapter.getById(this.id1);

        assertNotNull(response);
        assertEquals(this.userModelList.getFirst(), response);
        assertEquals(this.id1, response.id());

        verify(this.iUserRepository).findById(this.id1);
        verify(this.iMapperUserInfrastructure).toModel(this.userEntityList.getFirst());
    }

    @Test
    public void shouldReturnNotFoundUserExceptionWhenIsCalledMethodGetByIdWithParamNoExistis() {

        UUID idNoExistis = UUID.randomUUID();

        when(this.iUserRepository.findById(idNoExistis))
                .thenReturn(Optional.empty());

        NotFoundUserException exception = assertThrows(NotFoundUserException.class, () -> {
            this.getUserAdapter.getById(idNoExistis);
        });

        String expectedMessage = "User not found with id: " + idNoExistis;
        assertEquals(expectedMessage, exception.getMessage());
        assertEquals(NotFoundUserException.class, exception.getClass());

        verify(this.iUserRepository).findById(idNoExistis);
        verifyNoInteractions(this.iMapperUserInfrastructure);
    }

    @Test
    public void shouldReturnNotFoundUserExceptionWhenIsCalledMethodGetByIdWithParamIsNull() {

        UUID idNull = null;

        when(this.iUserRepository.findById(idNull))
                .thenReturn(Optional.empty());

        NotFoundUserException exception = assertThrows(NotFoundUserException.class, () -> {
            this.getUserAdapter.getById(idNull);
        });

        String expectedMessage = "User not found with id: " + idNull;
        assertEquals(expectedMessage, exception.getMessage());
        assertEquals(NotFoundUserException.class, exception.getClass());

        verify(this.iUserRepository).findById(idNull);
        verifyNoInteractions(this.iMapperUserInfrastructure);
    }

    @Test
    public void shouldReturnListOfUserModelWhenIsCalledMethodGetByNameWithParamName() {

        String name = "juan";

        List<UserEntity> entityList = this.userEntityList.stream()
                .filter(user -> Objects.equals(user.getName(), name))
                .toList();

        List<UserModel> modelList = this.userModelList.stream()
                .filter(user -> Objects.equals(user.name(), name))
                .toList();

        when(this.iUserRepository.findByName(name)).thenReturn(entityList);

        when(this.iMapperUserInfrastructure.toListModel(entityList))
                .thenReturn(modelList);

        List<UserModel> response = this.getUserAdapter.getByName(name);

        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals(modelList, response);
        assertEquals(this.id1, response.getFirst().id());

        verify(this.iUserRepository).findByName(name);
        verify(this.iMapperUserInfrastructure).toListModel(entityList);
    }

    @Test
    public void shouldReturnListOfEmptyWhenIsCalledMethodGetByNameWithParamNoExistis() {

        String name = "no existe";

        List<UserEntity> entityListEmpty = new ArrayList<UserEntity>();
        List<UserModel> modelListEmpty = new ArrayList<UserModel>();

        when(this.iUserRepository.findByName(name)).thenReturn(entityListEmpty);

        when(this.iMapperUserInfrastructure.toListModel(entityListEmpty))
                .thenReturn(modelListEmpty);

        List<UserModel> response = this.getUserAdapter.getByName(name);

        assertNotNull(response);
        assertEquals(0, response.size());
        assertEquals(modelListEmpty, response);

        verify(this.iUserRepository).findByName(name);
        verify(this.iMapperUserInfrastructure).toListModel(entityListEmpty);
    }

    @Test
    public void shouldReturnListOfEmptyWhenIsCalledMethodGetByNameWithParamIsNull() {

        String name = null;

        List<UserEntity> entityListEmpty = new ArrayList<UserEntity>();
        List<UserModel> modelListEmpty = new ArrayList<UserModel>();

        when(this.iUserRepository.findByName(name)).thenReturn(entityListEmpty);

        when(this.iMapperUserInfrastructure.toListModel(entityListEmpty))
                .thenReturn(modelListEmpty);

        List<UserModel> response = this.getUserAdapter.getByName(name);

        assertNotNull(response);
        assertEquals(0, response.size());
        assertEquals(modelListEmpty, response);

        verify(this.iUserRepository).findByName(name);
        verify(this.iMapperUserInfrastructure).toListModel(entityListEmpty);
    }

    @Test
    public void shouldReturnListOfUserModelWhenIsCalledMethodGetByLastNameWithParamLastName() {

        String lastName = "leon";

        List<UserEntity> entityList = this.userEntityList.stream()
                .filter(user -> Objects.equals(user.getLastName(), lastName))
                .toList();

        List<UserModel> modelList = this.userModelList.stream()
                .filter(user -> Objects.equals(user.lastName(), lastName))
                .toList();

        when(this.iUserRepository.findByLastName(lastName)).thenReturn(entityList);

        when(this.iMapperUserInfrastructure.toListModel(entityList))
                .thenReturn(modelList);

        List<UserModel> response = this.getUserAdapter.getByLastName(lastName);

        assertNotNull(response);
        assertEquals(2, response.size());
        assertEquals(modelList, response);
        assertEquals(this.id1, response.getFirst().id());

        verify(this.iUserRepository).findByLastName(lastName);
        verify(this.iMapperUserInfrastructure).toListModel(entityList);
    }

    @Test
    public void shouldReturnListOfEmptyWhenIsCalledMethodGetByLastNameWithParamNoExistis() {

        String lastName = "no existe";

        List<UserEntity> entityListEmpty = new ArrayList<UserEntity>();
        List<UserModel> modelListEmpty = new ArrayList<UserModel>();

        when(this.iUserRepository.findByLastName(lastName)).thenReturn(entityListEmpty);

        when(this.iMapperUserInfrastructure.toListModel(entityListEmpty))
                .thenReturn(modelListEmpty);

        List<UserModel> response = this.getUserAdapter.getByLastName(lastName);

        assertNotNull(response);
        assertEquals(0, response.size());
        assertEquals(modelListEmpty, response);

        verify(this.iUserRepository).findByLastName(lastName);
        verify(this.iMapperUserInfrastructure).toListModel(entityListEmpty);
    }

    @Test
    public void shouldReturnListOfEmptyWhenIsCalledMethodGetByLastNameWithParamIsNull() {

        String lastName = null;

        List<UserEntity> entityListEmpty = new ArrayList<UserEntity>();
        List<UserModel> modelListEmpty = new ArrayList<UserModel>();

        when(this.iUserRepository.findByLastName(lastName)).thenReturn(entityListEmpty);

        when(this.iMapperUserInfrastructure.toListModel(entityListEmpty))
                .thenReturn(modelListEmpty);

        List<UserModel> response = this.getUserAdapter.getByLastName(lastName);

        assertNotNull(response);
        assertEquals(0, response.size());
        assertEquals(modelListEmpty, response);

        verify(this.iUserRepository).findByLastName(lastName);
        verify(this.iMapperUserInfrastructure).toListModel(entityListEmpty);
    }
}