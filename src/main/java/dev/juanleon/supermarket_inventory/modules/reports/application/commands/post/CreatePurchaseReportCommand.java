package dev.juanleon.supermarket_inventory.modules.reports.application.commands.post;

import dev.juanleon.supermarket_inventory.modules.reports.application.dto.request.RequestReportDataPurchases;
import dev.juanleon.supermarket_inventory.share.mediator.IRequest;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseRequestDto;

public record CreatePurchaseReportCommand(
        RequestReportDataPurchases requestReportDataPurchases
) implements IRequest<ResponseRequestDto> { }
