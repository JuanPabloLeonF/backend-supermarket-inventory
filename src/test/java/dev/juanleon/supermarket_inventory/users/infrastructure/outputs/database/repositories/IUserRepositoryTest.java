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
                .lastName("garcia " + this.lastName)
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
    void shouldReturnListOfUserEntityWhenIsCalledMethodGetByName() {

        List<UserEntity> result = this.iUserRepository.findByName(this.name);

        assertEquals(2, result.size());
        result.forEach((user) -> {
            assertEquals(this.name, user.getName());
        });
    }

    @Test
    void shouldReturnListEmptyWhenIsCalledMethodGetByName() {
        List<UserEntity> result = this.iUserRepository.findByName("noExists");
        assertEquals(0, result.size());
    }

    @Test
    void shouldReturnListOfUserEntityWhenIsCalledMethodGetByLastName() {
        List<UserEntity> result = this.iUserRepository.findByLastName(this.lastName);

        assertEquals(1, result.size());
        result.forEach((user) -> {
            assertTrue(user.getLastName().contains(this.lastName));
        });
    }

    @Test
    void shouldReturnListOfEmptyWhenIsCalledMethodGetByLastName() {
        List<UserEntity> result = this.iUserRepository.findByLastName("noExists");
        assertEquals(0, result.size());
    }
}