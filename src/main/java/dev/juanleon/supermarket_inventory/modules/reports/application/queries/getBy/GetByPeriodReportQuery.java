package dev.juanleon.supermarket_inventory.modules.reports.application.queries.getBy;

import dev.juanleon.supermarket_inventory.share.mediator.IRequest;
import dev.juanleon.supermarket_inventory.share.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.modules.reports.application.dto.ResponseReport;

public record GetByPeriodReportQuery(
        String period,
        Integer page,
        Integer size
) implements IRequest<PagedResponse<ResponseReport>> {}
