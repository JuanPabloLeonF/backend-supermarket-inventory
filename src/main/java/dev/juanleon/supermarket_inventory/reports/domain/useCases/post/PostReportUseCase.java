package dev.juanleon.supermarket_inventory.reports.domain.useCases.post;

import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.employees.domain.models.EmployeeModel;
import dev.juanleon.supermarket_inventory.reports.domain.models.ReportModel;
import dev.juanleon.supermarket_inventory.reports.domain.models.SaleReportModel;
import dev.juanleon.supermarket_inventory.reports.domain.persistence.post.IPostReportPersistence;
import dev.juanleon.supermarket_inventory.reports.domain.ports.IEmployeeProviderReport;
import dev.juanleon.supermarket_inventory.reports.domain.ports.IPortFilesReports;
import dev.juanleon.supermarket_inventory.reports.domain.services.post.IPostReportService;

import java.util.UUID;

import static dev.juanleon.supermarket_inventory.common.configuration.AppConfigurationProperties.PATH_UPLOAD_FILES_PDF_SALES;
import static dev.juanleon.supermarket_inventory.files.domain.FileConstants.TEMPLATE_REPORT_SALES;

public class PostReportUseCase implements IPostReportService {

    private final IPostReportPersistence iPostReportPersistence;
    private final IEmployeeProviderReport iEmployeeProviderReport;
    private final IPortFilesReports iPortFilesReports;

    public PostReportUseCase(IPostReportPersistence iPostReportPersistence, IEmployeeProviderReport iEmployeeProviderReport, IPortFilesReports iPortFilesReports) {
        this.iPostReportPersistence = iPostReportPersistence;
        this.iEmployeeProviderReport = iEmployeeProviderReport;
        this.iPortFilesReports = iPortFilesReports;
    }

    @Override
    public ResponseModel createSales(ReportModel reportModel, SaleReportModel saleReportModel, UUID employeeId) {

        EmployeeModel employeeFound = this.iEmployeeProviderReport.getEmployeeById(employeeId);

        reportModel.setEmployee(employeeFound);
        String urlFile = this.iPortFilesReports.createPdf(
                    saleReportModel,
                    TEMPLATE_REPORT_SALES,
                    PATH_UPLOAD_FILES_PDF_SALES
            );
        reportModel.setFilePath(urlFile);
        return this.iPostReportPersistence.create(reportModel);
    }
}
