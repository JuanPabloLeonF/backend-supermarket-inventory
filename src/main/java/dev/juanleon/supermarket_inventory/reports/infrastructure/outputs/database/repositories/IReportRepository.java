package dev.juanleon.supermarket_inventory.reports.infrastructure.outputs.database.repositories;

import dev.juanleon.supermarket_inventory.reports.infrastructure.outputs.database.entities.ReportEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface IReportRepository extends JpaRepository<ReportEntity, UUID> {

    @Query("SELECT r FROM ReportEntity r WHERE LOWER(r.period) = LOWER(:period)")
    Page<ReportEntity> findByFullPeriod(@Param("period") String period, Pageable pageable);

    @Query("SELECT r FROM ReportEntity r WHERE r.period LIKE %:year%")
    Page<ReportEntity> findAllByYear(@Param("year") String year, Pageable pageable);
}
