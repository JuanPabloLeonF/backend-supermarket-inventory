package dev.juanleon.supermarket_inventory.modules.reports.application.handler.post;

import dev.juanleon.supermarket_inventory.modules.reports.application.dto.request.RequestReportSales;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseRequestDto;

public interface IPostReportHandler {
    ResponseRequestDto createSale(RequestReportSales requestReportSales);
}
