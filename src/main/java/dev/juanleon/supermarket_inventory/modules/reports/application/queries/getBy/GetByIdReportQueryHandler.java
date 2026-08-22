package dev.juanleon.supermarket_inventory.modules.reports.application.queries.getBy;

import dev.juanleon.supermarket_inventory.modules.reports.application.mappers.IMapperReportApplication;
import dev.juanleon.supermarket_inventory.modules.reports.domain.services.get.IGetReportService;
import dev.juanleon.supermarket_inventory.share.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.modules.reports.application.dto.response.ResponseReport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetByIdReportQueryHandler implements IRequestHandler<GetByIdReportQuery, ResponseReport> {

    private final IGetReportService iGetReportService;
    private final IMapperReportApplication iMapperReportApplication;

    @Override
    public ResponseReport handle(GetByIdReportQuery request) {
        return this.iMapperReportApplication.toResponse(this.iGetReportService.getById(request.id()));
    }

    @Override
    public Class<GetByIdReportQuery> getRequestType() {
        return GetByIdReportQuery.class;
    }
}
