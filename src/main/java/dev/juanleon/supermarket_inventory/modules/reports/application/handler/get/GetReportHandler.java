package dev.juanleon.supermarket_inventory.modules.reports.application.handler.get;

import dev.juanleon.supermarket_inventory.share.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.share.utils.dto.PaginationRequest;
import dev.juanleon.supermarket_inventory.share.utils.mappers.IMapperPaginationApp;
import dev.juanleon.supermarket_inventory.modules.reports.application.dto.response.ResponseReport;
import dev.juanleon.supermarket_inventory.modules.reports.application.mappers.IMapperReportApplication;
import dev.juanleon.supermarket_inventory.modules.reports.domain.models.ReportModel;
import dev.juanleon.supermarket_inventory.modules.reports.domain.services.get.IGetReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetReportHandler implements IGetReportHandler {

    private final IGetReportService iGetReportService;
    private final IMapperReportApplication iMapperReportApplication;
    private final IMapperPaginationApp iMapperPaginationApp;

    @Override
    public PagedResponse<ResponseReport> getAll(PaginationRequest paginationRequest) {
        PagedResponse<ReportModel> reportModelPagedResponse = this.iGetReportService.getAll(paginationRequest);
        return this.iMapperPaginationApp.pageResponseToPageResponseTypeResponse(reportModelPagedResponse, this.iMapperReportApplication::toResponse);
    }

    @Override
    public ResponseReport getById(UUID id) {
        return this.iMapperReportApplication.toResponse(this.iGetReportService.getById(id));
    }

    @Override
    public PagedResponse<ResponseReport> getByPeriod(String period, PaginationRequest paginationRequest) {
        PagedResponse<ReportModel> reportModelPagedResponse = this.iGetReportService.getByPeriod(period, paginationRequest);
        return this.iMapperPaginationApp.pageResponseToPageResponseTypeResponse(reportModelPagedResponse, this.iMapperReportApplication::toResponse);
    }

    @Override
    public PagedResponse<ResponseReport> getByYear(String year, PaginationRequest paginationRequest) {
        PagedResponse<ReportModel> reportModelPagedResponse = this.iGetReportService.getByYear(year, paginationRequest);
        return this.iMapperPaginationApp.pageResponseToPageResponseTypeResponse(reportModelPagedResponse, this.iMapperReportApplication::toResponse);
    }
}
