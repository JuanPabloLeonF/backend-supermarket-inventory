package dev.juanleon.supermarket_inventory.modules.reports.application.queries.getBy;

import dev.juanleon.supermarket_inventory.share.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.share.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.share.utils.dto.PaginationRequest;
import dev.juanleon.supermarket_inventory.modules.reports.application.dto.ResponseReport;
import dev.juanleon.supermarket_inventory.modules.reports.application.handler.get.IGetReportHandler;
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
