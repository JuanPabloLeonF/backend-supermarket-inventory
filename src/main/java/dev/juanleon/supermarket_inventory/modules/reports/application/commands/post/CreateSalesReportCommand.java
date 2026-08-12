package dev.juanleon.supermarket_inventory.modules.reports.application.commands.post;

import dev.juanleon.supermarket_inventory.modules.reports.application.dto.request.RequestReportSales;
import dev.juanleon.supermarket_inventory.share.mediator.IRequest;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseRequestDto;

public record CreateSalesReportCommand(RequestReportSales requestReportSales) implements IRequest<ResponseRequestDto> {

}
