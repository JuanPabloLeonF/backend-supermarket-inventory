package dev.juanleon.supermarket_inventory.reports.application.queries.getAll;

import dev.juanleon.supermarket_inventory.common.mediator.IRequest;
import dev.juanleon.supermarket_inventory.common.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.common.utils.dto.PaginationRequest;
import dev.juanleon.supermarket_inventory.reports.application.dto.ResponseReport;

public record GetAllReportQuery(PaginationRequest paginationRequest) implements IRequest<PagedResponse<ResponseReport>> {
}
