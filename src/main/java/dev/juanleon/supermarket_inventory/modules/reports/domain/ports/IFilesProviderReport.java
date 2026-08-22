package dev.juanleon.supermarket_inventory.modules.reports.domain.ports;

import dev.juanleon.supermarket_inventory.modules.purchases.domain.models.PurchaseModel;
import dev.juanleon.supermarket_inventory.modules.reports.domain.models.DataReportModel;
import dev.juanleon.supermarket_inventory.modules.sales.domain.models.SalesModel;

public interface IFilesProviderReport {
    String createPdfSales(DataReportModel<SalesModel> salesModel);
    String createPdfPurchase(DataReportModel<PurchaseModel> purchaseModel);
}
