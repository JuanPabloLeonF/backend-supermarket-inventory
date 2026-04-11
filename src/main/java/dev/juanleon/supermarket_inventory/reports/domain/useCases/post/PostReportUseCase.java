package dev.juanleon.supermarket_inventory.reports.domain.useCases.post;

import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.employees.domain.models.EmployeeModel;
import dev.juanleon.supermarket_inventory.employees.domain.services.get.IGetEmployeeService;
import dev.juanleon.supermarket_inventory.files.domain.IFilesService;
import dev.juanleon.supermarket_inventory.reports.domain.models.ReportModel;
import dev.juanleon.supermarket_inventory.reports.domain.models.SaleReportModel;
import dev.juanleon.supermarket_inventory.reports.domain.persistence.post.IPostReportPersistence;
import dev.juanleon.supermarket_inventory.reports.domain.services.post.IPostReportService;

import java.util.UUID;

import static dev.juanleon.supermarket_inventory.files.domain.FileConstants.TEMPLATE_REPORT_SALES;

public class PostReportUseCase implements IPostReportService {

    private final IPostReportPersistence iPostReportPersistence;
    private final IGetEmployeeService iGetEmployeeService;
    private final IFilesService iFilesService;

    public PostReportUseCase(IPostReportPersistence iPostReportPersistence, IGetEmployeeService iGetEmployeeService, IFilesService iFilesService) {
        this.iPostReportPersistence = iPostReportPersistence;
        this.iGetEmployeeService = iGetEmployeeService;
        this.iFilesService = iFilesService;
    }

    @Override
    public ResponseModel createSales(ReportModel reportModel, SaleReportModel saleReportModel, UUID employeeId) {

        EmployeeModel employeeFound = this.iGetEmployeeService.getById(employeeId);

        reportModel.setEmployee(employeeFound);
        String urlFile = this.iFilesService.createPdf(
                    saleReportModel,
                    TEMPLATE_REPORT_SALES
            );
        reportModel.setFilePath(urlFile);
        return this.iPostReportPersistence.create(reportModel);
    }
}
