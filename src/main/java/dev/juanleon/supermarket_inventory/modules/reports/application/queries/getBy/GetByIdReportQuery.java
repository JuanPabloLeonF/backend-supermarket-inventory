package dev.juanleon.supermarket_inventory.modules.reports.application.queries.getBy;

import dev.juanleon.supermarket_inventory.share.mediator.IRequest;
import dev.juanleon.supermarket_inventory.modules.reports.application.dto.response.ResponseReport;

import java.util.UUID;

public record GetByIdReportQuery(UUID id) implements IRequest<ResponseReport> {
}
