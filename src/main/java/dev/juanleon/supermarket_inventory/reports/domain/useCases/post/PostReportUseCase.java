package dev.juanleon.supermarket_inventory.reports.domain.useCases.post;

import dev.juanleon.supermarket_inventory.common.configuration.AppConfigurationProperties;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.employees.domain.models.EmployeeModel;
import dev.juanleon.supermarket_inventory.reports.domain.models.ReportModel;
import dev.juanleon.supermarket_inventory.reports.domain.models.SaleReportModel;
import dev.juanleon.supermarket_inventory.reports.domain.persistence.post.IPostReportPersistence;
import dev.juanleon.supermarket_inventory.reports.domain.ports.IPortEmployeeReportsGet;
import dev.juanleon.supermarket_inventory.reports.domain.ports.IPortFilesReports;
import dev.juanleon.supermarket_inventory.reports.domain.services.post.IPostReportService;

import java.util.UUID;

import static dev.juanleon.supermarket_inventory.files.domain.FileConstants.TEMPLATE_REPORT_SALES;

public class PostReportUseCase implements IPostReportService {

    private final IPostReportPersistence iPostReportPersistence;
    private final IPortEmployeeReportsGet iPortEmployeeReportsGet;
    private final IPortFilesReports iPortFilesReports;
    private final AppConfigurationProperties appConfigurationProperties;

    public PostReportUseCase(IPostReportPersistence iPostReportPersistence, IPortEmployeeReportsGet iPortEmployeeReportsGet, IPortFilesReports iPortFilesReports, AppConfigurationProperties appConfigurationProperties) {
        this.iPostReportPersistence = iPostReportPersistence;
        this.iPortEmployeeReportsGet = iPortEmployeeReportsGet;
        this.iPortFilesReports = iPortFilesReports;
        this.appConfigurationProperties = appConfigurationProperties;
    }

    @Override
    public ResponseModel createSales(ReportModel reportModel, SaleReportModel saleReportModel, UUID employeeId) {

        EmployeeModel employeeFound = this.iPortEmployeeReportsGet.getByIdForReports(employeeId);

        reportModel.setEmployee(employeeFound);
        String urlFile = this.iPortFilesReports.createPdf(
                    saleReportModel,
                    TEMPLATE_REPORT_SALES,
                    this.appConfigurationProperties.getPathUploadFilesPdfReportsSales()
            );
        reportModel.setFilePath(urlFile);
        return this.iPostReportPersistence.create(reportModel);
    }
}
