package dev.juanleon.supermarket_inventory.modules.employees.infrastructure.outputs.database.repositories;

import dev.juanleon.supermarket_inventory.modules.employees.infrastructure.outputs.database.entities.EmployeeEntity;
import dev.juanleon.supermarket_inventory.modules.employees.infrastructure.outputs.database.entities.UserEntity;
import dev.juanleon.supermarket_inventory.share.utils.enums.Roles;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jpa.test.autoconfigure.TestEntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class IEmployeeRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private IEmployeeRepository iEmployeeRepository;

    private final UserEntity userSave1  = UserEntity.builder()
            .name("juan")
            .lastName("leon")
            .password("contrasena123")
            .rol(Roles.ADMIN)
            .isActive(true)
            .createdAt(LocalDateTime.now())
            .updatedAt(LocalDateTime.now())
            .email("juan@gmail.com")
            .build();

    private final UserEntity userSave2  = UserEntity.builder()
            .name("miguel")
            .lastName("rodriguez")
            .password("1234567")
            .rol(Roles.USER)
            .isActive(true)
            .createdAt(LocalDateTime.now())
            .updatedAt(LocalDateTime.now())
            .email("miguel@gmail.com")
            .build();

    private final EmployeeEntity employee1 = EmployeeEntity.builder()
            .userEntity(userSave1)
            .nationalId("12345678")
            .phone("+57 3228843600")
            .address("calle 12B #17-29 aniversario 2")
            .urlImg("upload/src/img/nombreimagen.webp")
            .position("ADMIN")
            .salary(BigDecimal.valueOf(2300))
            .hireDate(LocalDate.now())
            .build();

    private final EmployeeEntity employee2 = EmployeeEntity.builder()
            .userEntity(userSave2)
            .nationalId("87654321")
            .phone("+57 3222222200")
            .address("calle 12B #17-29 aniversario 1")
            .urlImg("upload/src/img/nombreimagen2.webp")
            .position("EMPLOYEE")
            .salary(BigDecimal.valueOf(2300))
            .hireDate(LocalDate.now())
            .build();

    private EmployeeEntity employeeEntity1;
    private EmployeeEntity employeeEntity2;


    @BeforeEach
    void setUp() {
        this.employeeEntity1 = this.testEntityManager.persistAndFlush(employee1);
        this.employeeEntity2 = this.testEntityManager.persistAndFlush(employee2);
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
            if (entity.getUserEntity().equals(userSave1)) {
                assertEquals(entity.getUserEntity(), userSave1);
            }
        });

        assertTrue(result.getContent().contains(employeeEntity2));
        assertEquals(2, result.getTotalElements());
    }

    @Test
    void shouldReturnEmployeeEntityWhenIsCalledMethodFindById() {

        Optional<EmployeeEntity> optionalEmployeeEntity = this.iEmployeeRepository.findById(employeeEntity1.getId());

        assertTrue(optionalEmployeeEntity.isPresent());
        assertEquals(employeeEntity1, optionalEmployeeEntity.get());
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
                employee2.getUserEntity().getName(),
                employee2.getUserEntity().getLastName(),
                pageable
        );

        result.getContent().forEach(entity -> {
            if (entity.getUserEntity().equals(userSave2)) {
                assertEquals(entity.getUserEntity(), userSave2);
            }
        });

        assertTrue(result.getContent().contains(employeeEntity2));
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
                employee1.getPosition(),
                pageable
        );

        result.getContent().forEach(entity -> {
            if (entity.getUserEntity().equals(userSave1)) {
                assertEquals(entity.getUserEntity(), userSave1);
            }
        });

        assertTrue(result.getContent().contains(employeeEntity1));
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
                employee1.getHireDate(),
                pageable
        );

        result.getContent().forEach(entity -> {
            if (entity.getUserEntity().equals(userSave2)) {
                assertEquals(entity.getUserEntity(), userSave2);
            }
        });

        assertTrue(result.getContent().contains(employeeEntity1));
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