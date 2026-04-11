package dev.juanleon.supermarket_inventory.reports.domain.useCases.post;

import dev.juanleon.supermarket_inventory.common.configuration.AppConfigurationProperties;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.files.domain.IFilesService;
import dev.juanleon.supermarket_inventory.reports.domain.models.ReportModel;
import dev.juanleon.supermarket_inventory.reports.domain.models.SaleReportDto;
import dev.juanleon.supermarket_inventory.reports.domain.persistence.post.IPostReportPersistence;
import dev.juanleon.supermarket_inventory.reports.domain.services.post.IPostReportService;

import static dev.juanleon.supermarket_inventory.files.domain.FileConstants.TEMPLATE_REPORT_SALES;

public class PostReportUseCase implements IPostReportService {

    private final IPostReportPersistence iPostReportPersistence;
    private final IFilesService iFilesService;
    private final AppConfigurationProperties appConfigurationProperties;

    public PostReportUseCase(IPostReportPersistence iPostReportPersistence, IFilesService iFilesService, AppConfigurationProperties appConfigurationProperties) {
        this.iPostReportPersistence = iPostReportPersistence;
        this.iFilesService = iFilesService;
        this.appConfigurationProperties = appConfigurationProperties;
    }

    @Override
    public ResponseModel createSales(ReportModel reportModel, SaleReportDto saleReportDto) {
            String urlFile = this.iFilesService.createPdf(
                    saleReportDto,
                    TEMPLATE_REPORT_SALES,
                    this.appConfigurationProperties.getPathUploadFilesPdfReportsSales()
            );
            reportModel.setFilePath(urlFile);
            return this.iPostReportPersistence.create(reportModel);
    }
}
