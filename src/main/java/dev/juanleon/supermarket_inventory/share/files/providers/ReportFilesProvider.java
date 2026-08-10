package dev.juanleon.supermarket_inventory.share.files.providers;

import dev.juanleon.supermarket_inventory.share.files.services.PdfGeneratorService;
import dev.juanleon.supermarket_inventory.modules.reports.domain.models.SaleReportModel;
import dev.juanleon.supermarket_inventory.modules.reports.domain.ports.IFilesProviderReport;
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
