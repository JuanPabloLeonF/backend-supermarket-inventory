package dev.juanleon.supermarket_inventory.users.infrastructure.outputs.database.repositories;

import dev.juanleon.supermarket_inventory.users.infrastructure.outputs.database.entities.UserEntity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jpa.test.autoconfigure.TestEntityManager;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class IUserRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private IUserRepository iUserRepository;

    protected final String name = "juan";
    protected final String lastName = "leon";

    @BeforeEach
    void setUp() {
        UserEntity userSave1  = UserEntity.builder()
                .name(this.name)
                .lastName(this.lastName)
                .password("contrasena123")
                .rol("USER")
                .isActive(true)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .email("juan@gmail.com")
                .build();

        UserEntity userSave2  = UserEntity.builder()
                .name(this.name)
                .lastName(this.lastName)
                .password("1234567")
                .rol("ADMIN")
                .isActive(true)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .email("garcia@gmail.com")
                .build();


        this.testEntityManager.persistAndFlush(userSave1);
        this.testEntityManager.persistAndFlush(userSave2);
    }

    @AfterEach
    void tearDown() {
        this.testEntityManager.clear();
    }

    @Test
    void shouldReturnListOfUserEntityWhenIsCalledMethodGetByNameWithParamName() {

        List<UserEntity> result = this.iUserRepository.findByName(this.name);

        assertEquals(2, result.size());
        result.forEach((user) -> {
            assertEquals(this.name, user.getName());
        });
    }

    @Test
    void shouldReturnListEmptyWhenIsCalledMethodGetByNameWithParamNoExistis() {
        List<UserEntity> result = this.iUserRepository.findByName("noExists");
        assertEquals(0, result.size());
    }

    @Test
    void shouldReturnListEmptyWhenIsCalledMethodGetByNameWithParamNull() {
        List<UserEntity> result = this.iUserRepository.findByName(null);
        assertEquals(0, result.size());
    }

    @Test
    void shouldReturnListOfUserEntityWhenIsCalledMethodGetByLastNameWithParamLastName() {
        List<UserEntity> result = this.iUserRepository.findByLastName(this.lastName);

        assertEquals(2, result.size());
        result.forEach((user) -> {
            assertEquals(this.lastName, user.getLastName());
        });
    }

    @Test
    void shouldReturnListOfEmptyWhenIsCalledMethodGetByLastNameWithParamNoExistis() {
        List<UserEntity> result = this.iUserRepository.findByLastName("noExists");
        assertEquals(0, result.size());
    }

    @Test
    void shouldReturnListOfEmptyWhenIsCalledMethodGetByLastNameWithParamNull() {
        List<UserEntity> result = this.iUserRepository.findByLastName(null);
        assertEquals(0, result.size());
    }

    @Test
    void shouldPersistUserEntityWithGeneratedIdWhenIsCalledMethodSave() {

        UserEntity newUser = UserEntity.builder()
                .name("nuevo")
                .lastName("usuario")
                .email("persistido.repo@test.com")
                .password("Abcd1234@")
                .rol("USER")
                .isActive(true)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        UserEntity saved = this.iUserRepository.save(newUser);

        assertNotNull(saved.getId());

        Optional<UserEntity> found = this.iUserRepository.findById(saved.getId());
        assertTrue(found.isPresent());
        assertEquals("persistido.repo@test.com", found.get().getEmail());
        assertEquals("nuevo", found.get().getName());
    }
}