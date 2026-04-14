package dev.juanleon.supermarket_inventory.reports.domain.useCases.delete;

import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.files.domain.IFilesService;
import dev.juanleon.supermarket_inventory.reports.domain.persistence.delete.IDeleteReportPersistence;
import dev.juanleon.supermarket_inventory.reports.domain.services.delete.IDeleteReportService;

import java.util.UUID;

import static dev.juanleon.supermarket_inventory.common.utils.enums.MessagesApp.FORMAT_STRING_MESSAGE;
import static dev.juanleon.supermarket_inventory.common.utils.enums.MessagesApp.REPORT_DELETED_SUCCESSFULLY_BY_ID;

public class DeleteReportUseCases implements IDeleteReportService {

    private final IDeleteReportPersistence iDeleteReportPersistence;
    private final IFilesService iFilesService;

    public DeleteReportUseCases(IDeleteReportPersistence iDeleteReportPersistence, IFilesService iFilesService) {
        this.iDeleteReportPersistence = iDeleteReportPersistence;
        this.iFilesService = iFilesService;
    }

    @Override
    public ResponseModel deleteById(UUID id) {
        String urlFile = this.iDeleteReportPersistence.deleteById(id);
        String message = this.iFilesService.deleteReportSales(urlFile).message();
        return new ResponseModel(
                FORMAT_STRING_MESSAGE.format(
                        message,
                        REPORT_DELETED_SUCCESSFULLY_BY_ID.format(id)
                ));
    }
}
