package dev.juanleon.supermarket_inventory.modules.reports.application.handler.get;

import dev.juanleon.supermarket_inventory.share.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.share.utils.dto.PaginationRequest;
import dev.juanleon.supermarket_inventory.modules.reports.application.dto.response.ResponseReport;

import java.util.UUID;

public interface IGetReportHandler {
    PagedResponse<ResponseReport> getAll(PaginationRequest paginationRequest);
    ResponseReport getById(UUID id);
    PagedResponse<ResponseReport> getByPeriod(String period, PaginationRequest paginationRequest);
    PagedResponse<ResponseReport> getByYear(String year, PaginationRequest paginationRequest);
}
