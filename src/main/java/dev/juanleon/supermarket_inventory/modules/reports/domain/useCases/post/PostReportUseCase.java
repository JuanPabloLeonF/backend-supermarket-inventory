package dev.juanleon.supermarket_inventory.modules.reports.domain.useCases.post;

import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.modules.employees.domain.models.EmployeeModel;
import dev.juanleon.supermarket_inventory.modules.reports.domain.models.ReportModel;
import dev.juanleon.supermarket_inventory.modules.reports.domain.models.SaleReportModel;
import dev.juanleon.supermarket_inventory.modules.reports.domain.persistence.post.IPostReportPersistence;
import dev.juanleon.supermarket_inventory.modules.reports.domain.ports.IEmployeeProviderReport;
import dev.juanleon.supermarket_inventory.modules.reports.domain.ports.IFilesProviderReport;
import dev.juanleon.supermarket_inventory.modules.reports.domain.services.post.IPostReportService;

import java.util.UUID;

import static dev.juanleon.supermarket_inventory.share.configuration.AppConfigurationProperties.PATH_UPLOAD_FILES_PDF_SALES;
import static dev.juanleon.supermarket_inventory.share.files.utils.FileConstants.TEMPLATE_REPORT_SALES;

public class PostReportUseCase implements IPostReportService {

    private final IPostReportPersistence iPostReportPersistence;
    private final IEmployeeProviderReport iEmployeeProviderReport;
    private final IFilesProviderReport iFilesProviderReport;

    public PostReportUseCase(IPostReportPersistence iPostReportPersistence, IEmployeeProviderReport iEmployeeProviderReport, IFilesProviderReport iFilesProviderReport) {
        this.iPostReportPersistence = iPostReportPersistence;
        this.iEmployeeProviderReport = iEmployeeProviderReport;
        this.iFilesProviderReport = iFilesProviderReport;
    }

    @Override
    public ResponseModel createSales(ReportModel reportModel, SaleReportModel saleReportModel, UUID employeeId) {

        EmployeeModel employeeFound = this.iEmployeeProviderReport.getEmployeeById(employeeId);

        reportModel.setEmployee(employeeFound);
        String urlFile = this.iFilesProviderReport.createPdf(
                    saleReportModel,
                    TEMPLATE_REPORT_SALES,
                    PATH_UPLOAD_FILES_PDF_SALES
            );
        reportModel.setFilePath(urlFile);
        return this.iPostReportPersistence.create(reportModel);
    }
}
