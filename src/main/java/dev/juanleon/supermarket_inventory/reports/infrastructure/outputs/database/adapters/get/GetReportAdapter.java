package dev.juanleon.supermarket_inventory.reports.infrastructure.outputs.database.adapters.get;

import dev.juanleon.supermarket_inventory.common.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.common.utils.dto.PaginationRequest;
import dev.juanleon.supermarket_inventory.common.utils.mappers.IMapperPaginationApp;
import dev.juanleon.supermarket_inventory.reports.domain.models.ReportModel;
import dev.juanleon.supermarket_inventory.reports.domain.persistence.get.IGetReportPersistence;
import dev.juanleon.supermarket_inventory.reports.infrastructure.outputs.database.entities.ReportEntity;
import dev.juanleon.supermarket_inventory.reports.infrastructure.outputs.database.mappers.IMapperReportInfrastructure;
import dev.juanleon.supermarket_inventory.reports.infrastructure.outputs.database.repositories.IReportRepository;
import dev.juanleon.supermarket_inventory.reports.infrastructure.outputs.exceptions.NotFoundReportException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class GetReportAdapter implements IGetReportPersistence {

    private final IReportRepository iReportRepository;
    private final IMapperReportInfrastructure iMapperReportInfrastructure;
    private final IMapperPaginationApp iMapperPaginationApp;

    @Override
    public PagedResponse<ReportModel> getAll(PaginationRequest paginationRequest) {
        Pageable pageable = this.iMapperPaginationApp.toPageable(paginationRequest);
        Page<ReportEntity> reportEntityPage = this.iReportRepository.findAll(pageable);
        return this.iMapperPaginationApp.pagetoPagedResponse(reportEntityPage, this.iMapperReportInfrastructure::toModel);
    }

    @Override
    public ReportModel getById(UUID id) {
        return this.iReportRepository.findById(id)
                .map(this.iMapperReportInfrastructure::toModel)
                .orElseThrow(() -> new NotFoundReportException(id));
    }

    @Override
    public PagedResponse<ReportModel> getByPeriod(String period, PaginationRequest paginationRequest) {
        Pageable pageable = this.iMapperPaginationApp.toPageable(paginationRequest);
        Page<ReportEntity> reportEntityPage = this.iReportRepository.findByFullPeriod(period, pageable);
        return this.iMapperPaginationApp.pagetoPagedResponse(reportEntityPage, this.iMapperReportInfrastructure::toModel);
    }

    @Override
    public PagedResponse<ReportModel> getByYear(String year, PaginationRequest paginationRequest) {
        Pageable pageable = this.iMapperPaginationApp.toPageable(paginationRequest);
        Page<ReportEntity> reportEntityPage = this.iReportRepository.findAllByYear(year, pageable);
        return this.iMapperPaginationApp.pagetoPagedResponse(reportEntityPage, this.iMapperReportInfrastructure::toModel);
    }
}
