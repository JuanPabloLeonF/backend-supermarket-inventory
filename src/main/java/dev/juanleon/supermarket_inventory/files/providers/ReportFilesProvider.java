package dev.juanleon.supermarket_inventory.files.providers;

import dev.juanleon.supermarket_inventory.files.services.PdfGeneratorService;
import dev.juanleon.supermarket_inventory.reports.domain.models.SaleReportModel;
import dev.juanleon.supermarket_inventory.reports.domain.ports.IFilesProviderReport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReportFilesProvider implements IFilesProviderReport {

    private final PdfGeneratorService pdfGeneratorService;

    @Override
    public String createPdf(SaleReportModel saleReportModel, String templateName, String uploadUrl) {
        return pdfGeneratorService.createPdf(saleReportModel, templateName, uploadUrl);
    }
}
