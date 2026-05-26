package dev.juanleon.supermarket_inventory.reports.application.queries.getBy;

import dev.juanleon.supermarket_inventory.common.mediator.IRequest;
import dev.juanleon.supermarket_inventory.common.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.reports.application.dto.ResponseReport;

public record GetByYearReportQuery(
        String year,
        Integer page,
        Integer size
) implements IRequest<PagedResponse<ResponseReport>> { }
