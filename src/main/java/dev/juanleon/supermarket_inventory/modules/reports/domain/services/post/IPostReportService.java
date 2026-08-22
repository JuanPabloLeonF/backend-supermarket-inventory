package dev.juanleon.supermarket_inventory.modules.reports.domain.services.post;

import dev.juanleon.supermarket_inventory.modules.purchases.domain.models.PurchaseModel;
import dev.juanleon.supermarket_inventory.modules.reports.domain.models.DataReportModel;
import dev.juanleon.supermarket_inventory.modules.sales.domain.models.SalesModel;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.modules.reports.domain.models.ReportModel;

public interface IPostReportService {
    ResponseModel createSales(ReportModel reportModel, DataReportModel<SalesModel> dataReportModel);
    ResponseModel createPurchase(ReportModel reportModel, DataReportModel<PurchaseModel> dataReportModel);
}
