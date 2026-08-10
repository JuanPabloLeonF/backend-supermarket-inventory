package dev.juanleon.supermarket_inventory.modules.reports.domain.useCases.delete;

import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.modules.reports.domain.persistence.delete.IDeleteReportPersistence;
import dev.juanleon.supermarket_inventory.modules.reports.domain.services.delete.IDeleteReportService;

import java.util.UUID;

public class DeleteReportUseCases implements IDeleteReportService {

    private final IDeleteReportPersistence iDeleteReportPersistence;

    public DeleteReportUseCases(IDeleteReportPersistence iDeleteReportPersistence) {
        this.iDeleteReportPersistence = iDeleteReportPersistence;
    }

    @Override
    public ResponseModel deleteById(UUID id) {
        String response = this.iDeleteReportPersistence.deleteById(id);
        return new ResponseModel(response);
    }
}
