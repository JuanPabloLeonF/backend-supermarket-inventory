package dev.juanleon.supermarket_inventory.reports.domain.services.post;

import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.reports.domain.models.ReportModel;
import dev.juanleon.supermarket_inventory.reports.domain.models.SaleReportModel;

import java.util.UUID;

public interface IPostReportService {
    ResponseModel createSales(ReportModel reportModel, SaleReportModel saleReportModel, UUID employeeId);
}
