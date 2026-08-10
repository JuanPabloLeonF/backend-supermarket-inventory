package dev.juanleon.supermarket_inventory.modules.reports.domain.persistence.get;

import dev.juanleon.supermarket_inventory.share.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.share.utils.dto.PaginationRequest;
import dev.juanleon.supermarket_inventory.modules.reports.domain.models.ReportModel;

import java.util.UUID;

public interface IGetReportPersistence {
    PagedResponse<ReportModel> getAll(PaginationRequest paginationRequest);
    ReportModel getById(UUID id);
    PagedResponse<ReportModel> getByPeriod(String period, PaginationRequest paginationRequest);
    PagedResponse<ReportModel> getByYear(String year, PaginationRequest paginationRequest);
}
