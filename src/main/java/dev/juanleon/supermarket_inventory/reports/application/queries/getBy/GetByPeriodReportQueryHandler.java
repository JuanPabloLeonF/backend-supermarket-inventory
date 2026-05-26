package dev.juanleon.supermarket_inventory.reports.application.queries.getBy;

import dev.juanleon.supermarket_inventory.common.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.common.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.common.utils.dto.PaginationRequest;
import dev.juanleon.supermarket_inventory.reports.application.dto.ResponseReport;
import dev.juanleon.supermarket_inventory.reports.application.handler.get.IGetReportHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetByPeriodReportQueryHandler implements IRequestHandler<GetByPeriodReportQuery, PagedResponse<ResponseReport>> {

    private final IGetReportHandler iGetReportHandler;

    @Override
    public PagedResponse<ResponseReport> handle(GetByPeriodReportQuery request) {
        PaginationRequest data = PaginationRequest.builder()
                .page(request.page())
                .size(request.size())
                .build();
        return this.iGetReportHandler.getByPeriod(request.period(), data);
    }

    @Override
    public Class<GetByPeriodReportQuery> getRequestType() {
        return GetByPeriodReportQuery.class;
    }
}
