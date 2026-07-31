package dev.juanleon.supermarket_inventory.reports.domain.useCases.delete;

import dev.juanleon.supermarket_inventory.common.configuration.AppConfigurationProperties;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.reports.domain.persistence.delete.IDeleteReportPersistence;
import dev.juanleon.supermarket_inventory.reports.domain.ports.IPortFilesReports;
import dev.juanleon.supermarket_inventory.reports.domain.services.delete.IDeleteReportService;

import java.util.UUID;

import static dev.juanleon.supermarket_inventory.common.utils.enums.MessagesApp.FORMAT_STRING_MESSAGE;
import static dev.juanleon.supermarket_inventory.common.utils.enums.MessagesApp.REPORT_DELETED_SUCCESSFULLY_BY_ID;

public class DeleteReportUseCases implements IDeleteReportService {

    private final IDeleteReportPersistence iDeleteReportPersistence;
    private final IPortFilesReports iPortFilesReports;
    private final AppConfigurationProperties appConfigurationProperties;

    public DeleteReportUseCases(IDeleteReportPersistence iDeleteReportPersistence, IPortFilesReports iPortFilesReports, AppConfigurationProperties appConfigurationProperties) {
        this.iDeleteReportPersistence = iDeleteReportPersistence;
        this.iPortFilesReports = iPortFilesReports;
        this.appConfigurationProperties = appConfigurationProperties;
    }

    @Override
    public ResponseModel deleteById(UUID id) {
        String urlFile = this.iDeleteReportPersistence.deleteById(id);
        String message = this.iPortFilesReports.deleteReportSales(
                urlFile,
                this.appConfigurationProperties.getPathUploadFilesPdfReportsSales()
                ).message();
        return new ResponseModel(
                FORMAT_STRING_MESSAGE.format(
                        message,
                        REPORT_DELETED_SUCCESSFULLY_BY_ID.format(id)
                ));
    }
}
