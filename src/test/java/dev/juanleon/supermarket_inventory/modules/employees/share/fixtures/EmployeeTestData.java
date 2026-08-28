package dev.juanleon.supermarket_inventory.modules.employees.share.fixtures;

import dev.juanleon.supermarket_inventory.modules.employees.domain.models.EmployeeModel;
import dev.juanleon.supermarket_inventory.modules.employees.domain.models.UserModel;
import dev.juanleon.supermarket_inventory.modules.employees.infrastructure.outputs.database.entities.EmployeeEntity;
import dev.juanleon.supermarket_inventory.modules.employees.infrastructure.outputs.database.entities.UserEntity;
import dev.juanleon.supermarket_inventory.share.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.share.utils.dto.PaginationRequest;
import dev.juanleon.supermarket_inventory.share.utils.enums.Roles;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public final class EmployeeTestData {

    private EmployeeTestData() {}

    public static final UUID employeeId1 = UUID.fromString("11111111-1111-1111-1111-111111111111");
    public static final UUID employeeId2 = UUID.fromString("22222222-2222-2222-2222-222222222222");
    public static final UUID userId1 = UUID.fromString("33333333-3333-3333-3333-333333333333");
    public static final UUID userId2 = UUID.fromString("44444444-4444-4444-4444-444444444444");

    public static final UserEntity userEntity1 = UserEntity.builder()
            .id(userId1)
            .name("juan")
            .lastName("leon")
            .email("juan123@gmail.com")
            .password("1234567")
            .rol(Roles.ADMIN)
            .isActive(true)
            .createdAt(LocalDateTime.now())
            .updatedAt(LocalDateTime.now())
            .build();

    public static final UserEntity userEntity2 = UserEntity.builder()
            .id(userId2)
            .name("pipe")
            .lastName("leon")
            .email("pipe123@gmail.com")
            .password("123456789")
            .rol(Roles.USER)
            .isActive(true)
            .createdAt(LocalDateTime.now())
            .updatedAt(LocalDateTime.now())
            .build();

    public static final EmployeeEntity employeeEntity1 = EmployeeEntity.builder()
            .id(employeeId1)
            .userEntity(userEntity1)
            .nationalId("12345678")
            .phone("+57 3228843600")
            .address("calle 12B #17-29")
            .urlImg("upload/src/img/juan.webp")
            .position("ADMIN")
            .salary(BigDecimal.valueOf(2300))
            .hireDate(LocalDate.of(2025, 1, 15))
            .build();

    public static final EmployeeEntity employeeEntity2 = EmployeeEntity.builder()
            .id(employeeId2)
            .userEntity(userEntity2)
            .nationalId("87654321")
            .phone("+57 3222222200")
            .address("calle 15 #20-10")
            .urlImg("upload/src/img/pipe.webp")
            .position("EMPLOYEE")
            .salary(BigDecimal.valueOf(1800))
            .hireDate(LocalDate.of(2025, 3, 20))
            .build();

    public static final UserModel userModel1 = UserModel.builder()
            .id(userId1)
            .name("juan")
            .lastName("leon")
            .email("juan123@gmail.com")
            .password("1234567")
            .rol(Roles.ADMIN)
            .isActive(true)
            .createdAt(LocalDateTime.now())
            .updatedAt(LocalDateTime.now())
            .build();

    public static final UserModel userModel2 = UserModel.builder()
            .id(userId2)
            .name("pipe")
            .lastName("leon")
            .email("pipe123@gmail.com")
            .password("123456789")
            .rol(Roles.USER)
            .isActive(true)
            .createdAt(LocalDateTime.now())
            .updatedAt(LocalDateTime.now())
            .build();

    public static final EmployeeModel employeeModel1 = EmployeeModel.builder()
            .id(employeeId1)
            .userModel(userModel1)
            .nationalId("12345678")
            .phone("+57 3228843600")
            .address("calle 12B #17-29")
            .urlImg("upload/src/img/juan.webp")
            .position("ADMIN")
            .salary(BigDecimal.valueOf(2300))
            .hireDate(LocalDate.of(2025, 1, 15))
            .build();

    public static final EmployeeModel employeeModel2 = EmployeeModel.builder()
            .id(employeeId2)
            .userModel(userModel2)
            .nationalId("87654321")
            .phone("+57 3222222200")
            .address("calle 15 #20-10")
            .urlImg("upload/src/img/pipe.webp")
            .position("EMPLOYEE")
            .salary(BigDecimal.valueOf(1800))
            .hireDate(LocalDate.of(2025, 3, 20))
            .build();

    public static final List<EmployeeEntity> employeeEntityList = List.of(employeeEntity1, employeeEntity2);
    public static final List<EmployeeModel> employeeModelList = List.of(employeeModel1, employeeModel2);

    public static final PaginationRequest paginationRequest = PaginationRequest.builder().page(0).size(5).build();
    public static final Pageable pageable = Pageable.ofSize(5).withPage(0);

    public static final Page<EmployeeEntity> employeeEntityPage = new PageImpl<>(employeeEntityList);
    public static final Page<EmployeeEntity> pageEmployeeEntityEmpty = new PageImpl<>(List.of());

    public static PagedResponse<EmployeeModel> createPagedResponse(List<EmployeeModel> content) {
        Page<EmployeeModel> page = new PageImpl<>(content);
        return new PagedResponse<>(
                page.getContent(),
                page.getNumber(),
                page.getSize(),
                page.getTotalElements(),
                page.getTotalPages(),
                page.isLast()
        );
    }

    public static Page<EmployeeEntity> createEntityPage(List<EmployeeEntity> entities) {
        return new PageImpl<>(entities);
    }

    public static EmployeeEntity createNewEmployeeEntityNotId(EmployeeEntity data) {
        UserEntity user = UserEntity.builder()
                .name(data.getUserEntity().getName())
                .lastName(data.getUserEntity().getLastName())
                .email(data.getUserEntity().getEmail())
                .password(data.getUserEntity().getPassword())
                .rol(data.getUserEntity().getRol())
                .isActive(data.getUserEntity().getIsActive())
                .createdAt(data.getUserEntity().getCreatedAt())
                .updatedAt(data.getUserEntity().getUpdatedAt())
                .build();

        return EmployeeEntity.builder()
                .userEntity(user)
                .nationalId(data.getNationalId())
                .phone(data.getPhone())
                .address(data.getAddress())
                .urlImg(data.getUrlImg())
                .position(data.getPosition())
                .salary(data.getSalary())
                .hireDate(data.getHireDate())
                .build();
    }
}