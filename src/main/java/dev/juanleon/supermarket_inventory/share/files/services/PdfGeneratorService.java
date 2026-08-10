package dev.juanleon.supermarket_inventory.share.files.services;

import dev.juanleon.supermarket_inventory.share.files.storage.FileStorage;
import dev.juanleon.supermarket_inventory.share.files.utils.FilesUtil;
import dev.juanleon.supermarket_inventory.modules.reports.domain.models.SaleReportModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.InputStream;
import java.nio.file.Path;
import java.time.LocalDateTime;

import static dev.juanleon.supermarket_inventory.share.files.utils.FileConstants.PDF;
import static dev.juanleon.supermarket_inventory.share.files.utils.FileConstants.SALES_REPORT_MODEL;

@Service
@RequiredArgsConstructor
public class PdfGeneratorService {

    private final FileStorage fileStorage;
    private final TemplateEngine templateEngine;

    public String createPdf(SaleReportModel saleReportModel, String templateName, String uploadUrl) {
        saleReportModel.setCreatedAt(LocalDateTime.now().withNano(0));
        Context context = new Context();
        context.setVariable(SALES_REPORT_MODEL, saleReportModel);
        String htmlGenerated = templateEngine.process(templateName, context);

        InputStream pdfStream = FilesUtil.convertHtmlToPdf(htmlGenerated);

        String urlPdf = FilesUtil.generateUniqueFileName(templateName, PDF);
        Path uploadPath = FilesUtil.stringToPath(uploadUrl);
        this.fileStorage.createDirectoriesIfNotExists(uploadPath);
        this.fileStorage.storeFile(pdfStream, uploadPath.resolve(urlPdf));

        return urlPdf;
    }

}
