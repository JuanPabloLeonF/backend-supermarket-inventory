package dev.juanleon.supermarket_inventory.modules.employees.infrastructure.outputs.database.repositories;

import dev.juanleon.supermarket_inventory.modules.employees.infrastructure.outputs.database.entities.UserEntity;
import dev.juanleon.supermarket_inventory.share.utils.enums.Roles;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jpa.test.autoconfigure.TestEntityManager;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class IUserRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private IUserRepository iUserRepository;

    @BeforeEach
    void setUp() {
        UserEntity userSave1  = UserEntity.builder()
                .name("juan")
                .lastName("leon")
                .password("contrasena123")
                .rol(Roles.USER)
                .isActive(true)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .email("juan@gmail.com")
                .build();

        UserEntity userSave2  = UserEntity.builder()
                .name("camilo")
                .lastName("hernandez")
                .password("1234567")
                .rol(Roles.ADMIN)
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
    void shouldReturnUserEntityFindByEmail() {
        Optional<UserEntity> found = this.iUserRepository.findByEmail("juan@gmail.com");
        assertTrue(found.isPresent());
        assertEquals("juan@gmail.com", found.get().getEmail());
    }

}