package dev.juanleon.supermarket_inventory.reports.application.handler.get;

import dev.juanleon.supermarket_inventory.common.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.common.utils.dto.PaginationRequest;
import dev.juanleon.supermarket_inventory.reports.application.dto.ResponseReport;

import java.util.UUID;

public interface IGetReportHandler {
    PagedResponse<ResponseReport> getAll(PaginationRequest paginationRequest);
    ResponseReport getById(UUID id);
    PagedResponse<ResponseReport> getByPeriod(String period, PaginationRequest paginationRequest);
    PagedResponse<ResponseReport> getByYear(String year, PaginationRequest paginationRequest);
}
