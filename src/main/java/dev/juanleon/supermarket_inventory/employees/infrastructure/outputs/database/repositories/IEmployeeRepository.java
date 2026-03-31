package dev.juanleon.supermarket_inventory.employees.infrastructure.outputs.database.repositories;

import dev.juanleon.supermarket_inventory.employees.infrastructure.outputs.database.entities.EmployeeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.UUID;

public interface IEmployeeRepository extends JpaRepository<EmployeeEntity, UUID> {
    Page<EmployeeEntity> findByUserEntity_NameAndUserEntity_LastName(String name, String lastName, Pageable pageable);
    Page<EmployeeEntity> findByPosition(String position, Pageable pageable);
    Page<EmployeeEntity> findByHireDateGreaterThanEqual(LocalDateTime startDate, Pageable pageable);
}
