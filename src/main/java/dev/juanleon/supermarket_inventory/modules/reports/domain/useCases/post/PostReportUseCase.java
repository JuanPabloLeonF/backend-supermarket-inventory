package dev.juanleon.supermarket_inventory.modules.reports.domain.useCases.post;

import dev.juanleon.supermarket_inventory.modules.purchases.domain.models.PurchaseModel;
import dev.juanleon.supermarket_inventory.modules.reports.domain.ports.IPurchaseProviderReport;
import dev.juanleon.supermarket_inventory.modules.reports.domain.ports.ISaleProviderReport;
import dev.juanleon.supermarket_inventory.modules.sales.domain.models.SalesModel;
import dev.juanleon.supermarket_inventory.share.configuration.ConstantsApp;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.modules.reports.domain.models.ReportModel;
import dev.juanleon.supermarket_inventory.modules.reports.domain.models.DataReportModel;
import dev.juanleon.supermarket_inventory.modules.reports.domain.persistence.post.IPostReportPersistence;
import dev.juanleon.supermarket_inventory.modules.reports.domain.ports.IFilesProviderReport;
import dev.juanleon.supermarket_inventory.modules.reports.domain.services.post.IPostReportService;

public class PostReportUseCase implements IPostReportService {

    private final IPostReportPersistence iPostReportPersistence;
    private final ISaleProviderReport iSaleProviderReport;
    private final IPurchaseProviderReport iPurchaseProviderReport;
    private final IFilesProviderReport iFilesProviderReport;

    public PostReportUseCase(IPostReportPersistence iPostReportPersistence, ISaleProviderReport iSaleProviderReport, IPurchaseProviderReport iPurchaseProviderReport, IFilesProviderReport iFilesProviderReport) {
        this.iPostReportPersistence = iPostReportPersistence;
        this.iSaleProviderReport = iSaleProviderReport;
        this.iPurchaseProviderReport = iPurchaseProviderReport;
        this.iFilesProviderReport = iFilesProviderReport;
    }

    @Override
    public ResponseModel createSales(ReportModel reportModel, DataReportModel<SalesModel> dataReportModel) {

        SalesModel saleFound = this.iSaleProviderReport.getSaleById(
                dataReportModel.getModel().getId(),
                reportModel.getEmployee().getId()
        );

        dataReportModel.setModel(saleFound);
        reportModel.setEmployee(dataReportModel.getModel().getEmployeeModel());

        String urlFile = this.iFilesProviderReport.createPdfSales(dataReportModel);

        reportModel.setFilePath(urlFile);
        reportModel.setReportType(ConstantsApp.TYPE_SALES);
        return this.iPostReportPersistence.create(reportModel);
    }

    @Override
    public ResponseModel createPurchase(ReportModel reportModel, DataReportModel<PurchaseModel> dataReportModel) {
        
        PurchaseModel purchaseFound = this.iPurchaseProviderReport.getPurchaseById(
                dataReportModel.getModel().getId(),
                reportModel.getEmployee().getId(),
                dataReportModel.getModel().getProviderModel().getId()
        );

        dataReportModel.setModel(purchaseFound);
        dataReportModel.setCustomerName(purchaseFound.getProviderModel().getFullName());
        dataReportModel.setIdentificationCustomer(purchaseFound.getProviderModel().getIdentification());
        reportModel.setEmployee(purchaseFound.getEmployeeModel());

        String urlFile = this.iFilesProviderReport.createPdfPurchase(dataReportModel);
        reportModel.setFilePath(urlFile);
        reportModel.setReportType(ConstantsApp.TYPE_PURCHASES);
        return this.iPostReportPersistence.create(reportModel);
    }
}
