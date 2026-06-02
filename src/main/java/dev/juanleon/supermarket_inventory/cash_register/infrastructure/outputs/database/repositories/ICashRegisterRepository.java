package dev.juanleon.supermarket_inventory.cash_register.infrastructure.outputs.database.repositories;

import dev.juanleon.supermarket_inventory.cash_register.infrastructure.outputs.database.entities.CashRegisterEntity;
import org.jspecify.annotations.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ICashRegisterRepository extends JpaRepository<CashRegisterEntity, UUID> {

    @Override
    @NonNull
    @EntityGraph(attributePaths = {"employee", "employee.userEntity"})
    Page<CashRegisterEntity> findAll(@NonNull Pageable pageable);

    @Override
    @NonNull
    @EntityGraph(attributePaths = {"employee", "employee.userEntity"})
    Optional<CashRegisterEntity> findById(@NonNull UUID id);

    @EntityGraph(attributePaths = {"employee", "employee.userEntity"})
    Page<CashRegisterEntity> findByEmployee_Id(UUID id, Pageable pageable);
}
