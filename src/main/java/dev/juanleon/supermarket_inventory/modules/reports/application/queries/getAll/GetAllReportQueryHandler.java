package dev.juanleon.supermarket_inventory.modules.reports.application.queries.getAll;

import dev.juanleon.supermarket_inventory.share.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.share.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.share.utils.dto.PaginationRequest;
import dev.juanleon.supermarket_inventory.modules.reports.application.dto.ResponseReport;
import dev.juanleon.supermarket_inventory.modules.reports.application.handler.get.IGetReportHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetAllReportQueryHandler implements IRequestHandler<GetAllReportQuery, PagedResponse<ResponseReport>> {

    private final IGetReportHandler iGetReportHandler;

    @Override
    public PagedResponse<ResponseReport> handle(GetAllReportQuery request) {
        PaginationRequest data = PaginationRequest.builder()
                .page(request.page())
                .size(request.size())
                .build();
        return this.iGetReportHandler.getAll(data);
    }

    @Override
    public Class<GetAllReportQuery> getRequestType() {
        return GetAllReportQuery.class;
    }
}
