package dev.juanleon.supermarket_inventory.reports.application.handler.post;

import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.reports.application.dto.RequestReportDto;
import dev.juanleon.supermarket_inventory.reports.domain.models.SaleReportDto;

public interface IPostReportHandler {
    ResponseRequestDto create(RequestReportDto requestReportDto, SaleReportDto saleReportDto);
}
