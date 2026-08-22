package dev.juanleon.supermarket_inventory.share.files.providers;

import dev.juanleon.supermarket_inventory.modules.purchases.domain.models.PurchaseModel;
import dev.juanleon.supermarket_inventory.modules.reports.domain.models.DataReportModel;
import dev.juanleon.supermarket_inventory.modules.sales.domain.models.SalesModel;
import dev.juanleon.supermarket_inventory.share.files.services.PdfGeneratorService;
import dev.juanleon.supermarket_inventory.modules.reports.domain.ports.IFilesProviderReport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static dev.juanleon.supermarket_inventory.share.configuration.AppConfigurationProperties.PATH_UPLOAD_FILES_PDF_PURCHASES;
import static dev.juanleon.supermarket_inventory.share.configuration.AppConfigurationProperties.PATH_UPLOAD_FILES_PDF_SALES;
import static dev.juanleon.supermarket_inventory.share.files.utils.FileConstants.TEMPLATE_REPORT_PURCHASE;
import static dev.juanleon.supermarket_inventory.share.files.utils.FileConstants.TEMPLATE_REPORT_SALES;

@Component
@RequiredArgsConstructor
public class ReportFilesProvider implements IFilesProviderReport {

    private final PdfGeneratorService pdfGeneratorService;

    @Override
    public String createPdfSales(DataReportModel<SalesModel> dataReportModel) {
        return pdfGeneratorService.createPdfSales(
                dataReportModel,
                TEMPLATE_REPORT_SALES,
                PATH_UPLOAD_FILES_PDF_SALES
        );
    }

    @Override
    public String createPdfPurchase(DataReportModel<PurchaseModel> dataReportModel) {
        return pdfGeneratorService.createPdfPurchase(
                dataReportModel,
                TEMPLATE_REPORT_PURCHASE,
                PATH_UPLOAD_FILES_PDF_PURCHASES
        );
    }
}
