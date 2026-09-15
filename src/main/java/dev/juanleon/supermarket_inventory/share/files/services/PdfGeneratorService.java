package dev.juanleon.supermarket_inventory.share.files.services;

import dev.juanleon.supermarket_inventory.modules.purchases.domain.models.PurchaseModel;
import dev.juanleon.supermarket_inventory.modules.reports.domain.models.DataReportModel;
import dev.juanleon.supermarket_inventory.modules.sales.domain.models.SalesModel;
import dev.juanleon.supermarket_inventory.share.configuration.ConstantsApp;
import dev.juanleon.supermarket_inventory.share.files.events.FileCreatedEvent;
import dev.juanleon.supermarket_inventory.share.files.storage.ports.IFilesStore;
import dev.juanleon.supermarket_inventory.share.files.utils.FilesUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.InputStream;


@Service
public class PdfGeneratorService {

    @Qualifier("cloudinaryAdapter")
    private final IFilesStore store;
    private final TemplateEngine templateEngine;
    private final ApplicationEventPublisher applicationEventPublisher;

    public PdfGeneratorService(IFilesStore store, TemplateEngine templateEngine, ApplicationEventPublisher applicationEventPublisher) {
        this.store = store;
        this.templateEngine = templateEngine;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public String createPdfSales(DataReportModel<SalesModel> dataReportModel, String templateName, String folderName) {

        Context context = new Context();
        context.setVariable(ConstantsApp.SALES_REPORT_MODEL, dataReportModel);
        String htmlGenerated = templateEngine.process(templateName, context);

        try (InputStream pdfStream = FilesUtil.convertHtmlToPdf(htmlGenerated)) {

            String urlPdf = this.store.uploadPdf(pdfStream, folderName);
            this.applicationEventPublisher.publishEvent(new FileCreatedEvent(urlPdf));
            return urlPdf;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String createPdfPurchase(DataReportModel<PurchaseModel> dataReportModel, String templateName, String folderName) {
        Context context = new Context();
        context.setVariable(ConstantsApp.PURCHASE_REPORT_MODEL, dataReportModel);
        String htmlGenerated = templateEngine.process(templateName, context);

        try (InputStream pdfStream = FilesUtil.convertHtmlToPdf(htmlGenerated)) {

            String urlPdf = this.store.uploadPdf(pdfStream, folderName);
            this.applicationEventPublisher.publishEvent(new FileCreatedEvent(urlPdf));
            return urlPdf;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
