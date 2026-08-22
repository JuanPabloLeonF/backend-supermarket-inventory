package dev.juanleon.supermarket_inventory.modules.reports.application.queries.getBy;

import dev.juanleon.supermarket_inventory.modules.reports.application.mappers.IMapperReportApplication;
import dev.juanleon.supermarket_inventory.modules.reports.domain.models.ReportModel;
import dev.juanleon.supermarket_inventory.modules.reports.domain.services.get.IGetReportService;
import dev.juanleon.supermarket_inventory.share.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.share.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.share.utils.dto.PaginationRequest;
import dev.juanleon.supermarket_inventory.modules.reports.application.dto.response.ResponseReport;
import dev.juanleon.supermarket_inventory.share.utils.mappers.IMapperPaginationApp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetByYearReportQueryHandler implements IRequestHandler<GetByYearReportQuery, PagedResponse<ResponseReport>> {

    private final IGetReportService iGetReportService;
    private final IMapperReportApplication iMapperReportApplication;
    private final IMapperPaginationApp iMapperPaginationApp;

    @Override
    public PagedResponse<ResponseReport> handle(GetByYearReportQuery request) {
        PaginationRequest data = PaginationRequest.builder()
                .page(request.page())
                .size(request.size())
                .build();
        PagedResponse<ReportModel> reportModelPagedResponse = this.iGetReportService.getByYear(request.year(), data);
        return this.iMapperPaginationApp.pageResponseToPageResponseTypeResponse(reportModelPagedResponse, this.iMapperReportApplication::toResponse);
    }

    @Override
    public Class<GetByYearReportQuery> getRequestType() {
        return GetByYearReportQuery.class;
    }
}
