package dev.juanleon.supermarket_inventory.reports.application.handler.post;

import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.reports.application.dto.RequestReportDto;
import dev.juanleon.supermarket_inventory.reports.application.dto.RequestReportSalesData;

public interface IPostReportHandler {
    ResponseRequestDto createSale(RequestReportDto requestReportDto, RequestReportSalesData requestReportSalesData);
}
