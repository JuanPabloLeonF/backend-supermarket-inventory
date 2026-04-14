package dev.juanleon.supermarket_inventory.employees.infrastructure.outputs.database.repositories;

import dev.juanleon.supermarket_inventory.employees.infrastructure.outputs.database.entities.EmployeeEntity;
import org.jspecify.annotations.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

public interface IEmployeeRepository extends JpaRepository<EmployeeEntity, UUID> {

    @Override
    @NonNull
    @EntityGraph(attributePaths = {"userEntity"})
    Page<EmployeeEntity> findAll(@NonNull Pageable pageable);

    @Override
    @NonNull
    @EntityGraph(attributePaths = {"userEntity"})
    Optional<EmployeeEntity> findById(@NonNull UUID id);

    @EntityGraph(attributePaths = {"userEntity"})
    Page<EmployeeEntity> findByUserEntity_NameAndUserEntity_LastName(String name, String lastName, Pageable pageable);

    @EntityGraph(attributePaths = {"userEntity"})
    Page<EmployeeEntity> findByPosition(String position, Pageable pageable);

    @EntityGraph(attributePaths = {"userEntity"})
    Page<EmployeeEntity> findByHireDateGreaterThanEqual(LocalDateTime startDate, Pageable pageable);
}
