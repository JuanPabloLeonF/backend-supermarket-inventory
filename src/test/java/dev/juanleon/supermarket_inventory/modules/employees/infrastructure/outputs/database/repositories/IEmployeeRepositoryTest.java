package dev.juanleon.supermarket_inventory.modules.employees.infrastructure.outputs.database.repositories;

import dev.juanleon.supermarket_inventory.modules.employees.infrastructure.outputs.database.entities.EmployeeEntity;
import dev.juanleon.supermarket_inventory.modules.employees.infrastructure.outputs.database.entities.UserEntity;
import dev.juanleon.supermarket_inventory.modules.employees.share.fixtures.EmployeeTestData;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jpa.test.autoconfigure.TestEntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class IEmployeeRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private IEmployeeRepository iEmployeeRepository;

    private EmployeeEntity employeeEntitySave1;
    private EmployeeEntity employeeEntitySave2;
    private UserEntity userEntitySave1;
    private UserEntity userEntitySave2;

    @BeforeEach
    void setUp() {
        employeeEntitySave1 = this.testEntityManager.persistAndFlush(EmployeeTestData.createNewEmployeeEntityNotId(EmployeeTestData.employeeEntity1));
        employeeEntitySave2 = this.testEntityManager.persistAndFlush(EmployeeTestData.createNewEmployeeEntityNotId(EmployeeTestData.employeeEntity2));
        userEntitySave1 = employeeEntitySave1.getUserEntity();
        userEntitySave2 = employeeEntitySave2.getUserEntity();
    }

    @AfterEach
    void tearDown() {
        this.testEntityManager.clear();
    }


    @Test
    void shouldReturnPageOfEmployeeEntityWithUserEntity() {

        Pageable pageable = Pageable.ofSize(5);

        Page<EmployeeEntity> result = this.iEmployeeRepository.findAll(pageable);

        result.getContent().forEach(entity -> {
            if (entity.getUserEntity().equals(userEntitySave1)) {
                assertEquals(userEntitySave1, entity.getUserEntity());
            }
        });

        assertTrue(result.getContent().contains(employeeEntitySave2));
        assertEquals(2, result.getTotalElements());
    }

    @Test
    void shouldReturnEmployeeEntityWhenIsCalledMethodFindById() {

        Optional<EmployeeEntity> optionalEmployeeEntity = this.iEmployeeRepository.findById(
                employeeEntitySave1.getId()
        );

        assertTrue(optionalEmployeeEntity.isPresent());
        assertEquals(employeeEntitySave1, optionalEmployeeEntity.get());
    }

    @Test
    void shouldReturnEmployeeEntityWhenIsCalledMethodFindByIdWithParamIsIncorrect() {
        Optional<EmployeeEntity> optionalEmployeeEntity = this.iEmployeeRepository.findById(UUID.randomUUID());
        assertTrue(optionalEmployeeEntity.isEmpty());
    }

    @Test
    void shouldReturnPageEmployeeEntityWhenIsCalledMethodFindByUserEntity_NameAndUserEntity_LastName() {

        Pageable pageable = Pageable.ofSize(5);

        Page<EmployeeEntity> result = this.iEmployeeRepository.findByUserEntity_NameAndUserEntity_LastName(
                employeeEntitySave2.getUserEntity().getName(),
                employeeEntitySave2.getUserEntity().getLastName(),
                pageable
        );

        result.getContent().forEach(entity -> {
            if (entity.getUserEntity().equals(userEntitySave2)) {
                assertEquals(userEntitySave2, entity.getUserEntity());
            }
        });

        assertTrue(result.getContent().contains(employeeEntitySave2));
        assertEquals(1, result.getTotalElements());
    }

    @Test
    void shouldReturnPageEmptyWhenIsCalledMethodFindByUserEntity_NameAndUserEntity_LastNameWithParamsIsIncorrect() {

        Pageable pageable = Pageable.ofSize(5);

        Page<EmployeeEntity> result = this.iEmployeeRepository.findByUserEntity_NameAndUserEntity_LastName(
                "nombre",
                "apellido",
                pageable
        );

        assertTrue(result.getContent().isEmpty());
        assertEquals(0, result.getTotalElements());
    }

    @Test
    void shouldReturnPageEmployeeEntityWhenIsCalledMethodFindByPosition() {

        Pageable pageable = Pageable.ofSize(5);

        Page<EmployeeEntity> result = this.iEmployeeRepository.findByPosition(
                employeeEntitySave1.getPosition(),
                pageable
        );

        result.getContent().forEach(entity -> {
            if (entity.getUserEntity().equals(userEntitySave1)) {
                assertEquals(userEntitySave1, entity.getUserEntity());
            }
        });

        assertTrue(result.getContent().contains(employeeEntitySave1));
        assertEquals(1, result.getTotalElements());
    }

    @Test
    void shouldReturnPageEmptyWhenIsCalledMethodFindByPositionWithParamsIsIncorrect() {

        Pageable pageable = Pageable.ofSize(5);

        Page<EmployeeEntity> result = this.iEmployeeRepository.findByPosition(
                "NOTHING",
                pageable
        );

        assertTrue(result.getContent().isEmpty());
        assertEquals(0, result.getTotalElements());
    }

    @Test
    void shouldReturnPageEmployeeEntityWhenIsCalledMethodFindByHireDateGreaterThanEqual() {

        Pageable pageable = Pageable.ofSize(5);

        Page<EmployeeEntity> result = this.iEmployeeRepository.findByHireDateGreaterThanEqual(
                employeeEntitySave1.getHireDate(),
                pageable
        );

        result.getContent().forEach(entity -> {
            if (entity.getUserEntity().equals(userEntitySave1)) {
                assertEquals(userEntitySave1, entity.getUserEntity());
            }
        });

        assertTrue(result.getContent().contains(employeeEntitySave2));
        assertEquals(2, result.getTotalElements());
    }

    @Test
    void shouldReturnPageEmptyWhenIsCalledMethodFindByHireDateGreaterThanEqualWithParamsIsIncorrect() {

        Pageable pageable = Pageable.ofSize(5);

        Page<EmployeeEntity> result = this.iEmployeeRepository.findByHireDateGreaterThanEqual(
                LocalDate.of(2030, 1, 1),
                pageable
        );

        assertTrue(result.getContent().isEmpty());
        assertEquals(0, result.getTotalElements());
    }

}