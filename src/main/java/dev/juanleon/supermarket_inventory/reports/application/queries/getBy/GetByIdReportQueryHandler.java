package dev.juanleon.supermarket_inventory.reports.application.queries.getBy;

import dev.juanleon.supermarket_inventory.common.mediator.IRequestHandler;
import dev.juanleon.supermarket_inventory.reports.application.dto.ResponseReport;
import dev.juanleon.supermarket_inventory.reports.application.handler.get.IGetReportHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetByIdReportQueryHandler implements IRequestHandler<GetByIdReportQuery, ResponseReport> {

    private final IGetReportHandler iGetReportHandler;

    @Override
    public ResponseReport handle(GetByIdReportQuery request) {
        return this.iGetReportHandler.getById(request.id());
    }

    @Override
    public Class<GetByIdReportQuery> getRequestType() {
        return GetByIdReportQuery.class;
    }
}
