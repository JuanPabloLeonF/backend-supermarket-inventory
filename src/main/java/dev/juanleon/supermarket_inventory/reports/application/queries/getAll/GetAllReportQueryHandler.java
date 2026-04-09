package dev.juanleon.supermarket_inventory.reports.application.queries.getAll;

import dev.juanleon.supermarket_inventory.common.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.common.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.reports.application.dto.ResponseReport;
import dev.juanleon.supermarket_inventory.reports.application.handler.get.IGetReportHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetAllReportQueryHandler implements IRequestHandler<GetAllReportQuery, PagedResponse<ResponseReport>> {

    private final IGetReportHandler iGetReportHandler;

    @Override
    public PagedResponse<ResponseReport> handle(GetAllReportQuery request) {
        return this.iGetReportHandler.getAll(request.paginationRequest());
    }

    @Override
    public Class<GetAllReportQuery> getRequestType() {
        return GetAllReportQuery.class;
    }
}
