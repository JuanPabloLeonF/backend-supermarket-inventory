package dev.juanleon.supermarket_inventory.reports.domain.services.get;

import dev.juanleon.supermarket_inventory.common.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.common.utils.dto.PaginationRequest;
import dev.juanleon.supermarket_inventory.reports.domain.models.ReportModel;

import java.util.UUID;

public interface IGetReportService {
    PagedResponse<ReportModel> getAll(PaginationRequest paginationRequest);
    ReportModel getById(UUID id);
    PagedResponse<ReportModel> getByPeriod(String period, PaginationRequest paginationRequest);
    PagedResponse<ReportModel> getByYear(String year, PaginationRequest paginationRequest);
}
