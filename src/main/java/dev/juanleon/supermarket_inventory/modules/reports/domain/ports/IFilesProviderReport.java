package dev.juanleon.supermarket_inventory.modules.reports.domain.ports;

import dev.juanleon.supermarket_inventory.modules.reports.domain.models.SaleReportModel;

public interface IFilesProviderReport {
    String createPdf(SaleReportModel saleReportModel, String templateName, String uploadUrl);
}
