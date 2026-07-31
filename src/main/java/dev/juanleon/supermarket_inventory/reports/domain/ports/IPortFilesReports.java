package dev.juanleon.supermarket_inventory.reports.domain.ports;

import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.reports.domain.models.SaleReportModel;

public interface IPortFilesReports {
    ResponseModel deleteReportSales(String urlFile, String uploadUrl);
    String createPdf(SaleReportModel saleReportModel, String templateName, String uploadUrl);
}
