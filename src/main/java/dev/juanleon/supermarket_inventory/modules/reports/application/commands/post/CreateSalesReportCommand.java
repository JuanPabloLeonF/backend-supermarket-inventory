package dev.juanleon.supermarket_inventory.modules.reports.application.commands.post;

import dev.juanleon.supermarket_inventory.share.mediator.IRequest;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.modules.reports.application.dto.RequestReportDto;
import dev.juanleon.supermarket_inventory.modules.reports.application.dto.RequestReportSalesData;

public record CreateSalesReportCommand(
        RequestReportDto requestReportDto,
        RequestReportSalesData requestReportSalesData
) implements IRequest<ResponseRequestDto> {

}
