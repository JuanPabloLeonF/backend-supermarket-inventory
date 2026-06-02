package dev.juanleon.supermarket_inventory.sales.infrastructure.outputs.database.repositories;

import dev.juanleon.supermarket_inventory.sales.infrastructure.outputs.database.entities.SalesEntity;
import org.jspecify.annotations.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

public interface ISalesRepository extends JpaRepository<SalesEntity, UUID> {

    @Override
    @NonNull
    @EntityGraph(attributePaths = {"employee", "employee.userEntity"})
    Page<SalesEntity> findAll(@NonNull Pageable pageable);

    @EntityGraph(attributePaths = {"employee", "employee.userEntity"})
    Page<SalesEntity> findByEmployee_Id(UUID id, Pageable pageable);

    @EntityGraph(attributePaths = {"employee", "employee.userEntity"})
    Page<SalesEntity> findByDateSaleGreaterThanEqual(LocalDateTime dateSale, Pageable pageable);

    @EntityGraph(attributePaths = {"employee", "employee.userEntity"})
    Page<SalesEntity> findByMethodPayment(String methodPayment, Pageable pageable);

    @EntityGraph(attributePaths = {"employee", "employee.userEntity"})
    Page<SalesEntity> findByStatus(String status, Pageable pageable);

    @EntityGraph(attributePaths = {"employee", "employee.userEntity"})
    Page<SalesEntity> findByDiscountGreaterThanEqual(BigDecimal discount, Pageable pageable);

    @Override
    @NonNull
    @EntityGraph(attributePaths = {"employee", "employee.userEntity"})
    Optional<SalesEntity> findById(@NonNull UUID id);

    @EntityGraph(attributePaths = {"employee", "employee.userEntity"})
    Optional<SalesEntity> findByNumberSale(UUID numberSale);
}
