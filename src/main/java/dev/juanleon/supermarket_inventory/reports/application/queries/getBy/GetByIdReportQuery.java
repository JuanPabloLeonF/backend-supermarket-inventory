package dev.juanleon.supermarket_inventory.reports.application.queries.getBy;

import dev.juanleon.supermarket_inventory.common.mediator.IRequest;
import dev.juanleon.supermarket_inventory.reports.application.dto.ResponseReport;

import java.util.UUID;

public record GetByIdReportQuery(UUID id) implements IRequest<ResponseReport> {
}
