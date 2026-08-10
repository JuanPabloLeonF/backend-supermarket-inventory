package dev.juanleon.supermarket_inventory.modules.reports.application.handler.post;

import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.modules.reports.application.dto.RequestReportDto;
import dev.juanleon.supermarket_inventory.modules.reports.application.dto.RequestReportSalesData;

public interface IPostReportHandler {
    ResponseRequestDto createSale(RequestReportDto requestReportDto, RequestReportSalesData requestReportSalesData);
}
