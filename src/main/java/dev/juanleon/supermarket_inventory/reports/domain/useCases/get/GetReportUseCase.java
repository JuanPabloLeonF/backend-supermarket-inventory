package dev.juanleon.supermarket_inventory.reports.domain.useCases.get;

import dev.juanleon.supermarket_inventory.common.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.common.utils.dto.PaginationRequest;
import dev.juanleon.supermarket_inventory.reports.domain.models.ReportModel;
import dev.juanleon.supermarket_inventory.reports.domain.persistence.get.IGetReportPersistence;
import dev.juanleon.supermarket_inventory.reports.domain.services.get.IGetReportService;

import java.util.UUID;

public class GetReportUseCase implements IGetReportService {

    private final IGetReportPersistence iGetReportPersistence;

    public GetReportUseCase(IGetReportPersistence iGetReportPersistence) {
        this.iGetReportPersistence = iGetReportPersistence;
    }

    @Override
    public PagedResponse<ReportModel> getAll(PaginationRequest paginationRequest) {
        return iGetReportPersistence.getAll(paginationRequest);
    }

    @Override
    public ReportModel getById(UUID id) {
        return this.iGetReportPersistence.getById(id);
    }

    @Override
    public PagedResponse<ReportModel> getByPeriod(String period, PaginationRequest paginationRequest) {
        return this.iGetReportPersistence.getByPeriod(period, paginationRequest);
    }

    @Override
    public PagedResponse<ReportModel> getByYear(String year, PaginationRequest paginationRequest) {
        return this.iGetReportPersistence.getByYear(year, paginationRequest);
    }
}
