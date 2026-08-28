package dev.juanleon.supermarket_inventory.modules.employees.infrastructure.outputs.database.repositories;

import dev.juanleon.supermarket_inventory.modules.employees.infrastructure.outputs.database.entities.UserEntity;
import dev.juanleon.supermarket_inventory.modules.employees.share.fixtures.UserTestData;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jpa.test.autoconfigure.TestEntityManager;

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
        this.testEntityManager.persistAndFlush(UserTestData.userSave1);
        this.testEntityManager.persistAndFlush(UserTestData.userSave2);
    }

    @AfterEach
    void tearDown() {
        this.testEntityManager.clear();
    }

    @Test
    void shouldReturnUserEntityFindByEmail() {
        Optional<UserEntity> found = this.iUserRepository.findByEmail(UserTestData.userSave1.getEmail());
        assertTrue(found.isPresent());
        assertEquals(UserTestData.userSave1.getEmail(), found.get().getEmail());
    }

}