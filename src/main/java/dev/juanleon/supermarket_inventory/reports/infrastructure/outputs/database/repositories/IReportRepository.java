package dev.juanleon.supermarket_inventory.reports.infrastructure.outputs.database.repositories;

import dev.juanleon.supermarket_inventory.reports.infrastructure.outputs.database.entities.ReportEntity;
import org.jspecify.annotations.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface IReportRepository extends JpaRepository<ReportEntity, UUID> {

    @Override
    @NonNull
    @EntityGraph(attributePaths = {"employee", "employee.userEntity"})
    Page<ReportEntity> findAll(@NonNull Pageable pageable);

    @Override
    @NonNull
    @EntityGraph(attributePaths = {"employee", "employee.userEntity"})
    Optional<ReportEntity> findById(@NonNull UUID id);

    @EntityGraph(attributePaths = {"employee", "employee.userEntity"})
    @Query("SELECT r FROM ReportEntity r WHERE LOWER(r.period) = LOWER(:period)")
    Page<ReportEntity> findByFullPeriod(@Param("period") String period, Pageable pageable);

    @EntityGraph(attributePaths = {"employee", "employee.userEntity"})
    @Query("SELECT r FROM ReportEntity r WHERE r.period LIKE %:year%")
    Page<ReportEntity> findAllByYear(@Param("year") String year, Pageable pageable);

}
