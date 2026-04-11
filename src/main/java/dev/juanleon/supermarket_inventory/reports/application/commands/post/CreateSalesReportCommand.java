package dev.juanleon.supermarket_inventory.reports.application.commands.post;

import dev.juanleon.supermarket_inventory.common.mediator.IRequest;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.reports.application.dto.RequestReportDto;
import dev.juanleon.supermarket_inventory.reports.application.dto.RequestReportSalesData;

public record CreateSalesReportCommand(
        RequestReportDto requestReportDto,
        RequestReportSalesData requestReportSalesData
) implements IRequest<ResponseRequestDto> {

}
