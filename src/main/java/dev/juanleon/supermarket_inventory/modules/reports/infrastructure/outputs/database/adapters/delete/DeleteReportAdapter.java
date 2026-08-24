package dev.juanleon.supermarket_inventory.modules.reports.infrastructure.outputs.database.adapters.delete;

import dev.juanleon.supermarket_inventory.share.configuration.ConstantsApp;
import dev.juanleon.supermarket_inventory.share.files.events.FileDeletedEvent;
import dev.juanleon.supermarket_inventory.modules.reports.domain.persistence.delete.IDeleteReportPersistence;
import dev.juanleon.supermarket_inventory.modules.reports.infrastructure.outputs.database.repositories.IReportRepository;
import dev.juanleon.supermarket_inventory.modules.reports.infrastructure.outputs.exceptions.NotFoundReportException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Repository;

import java.util.UUID;

import static dev.juanleon.supermarket_inventory.share.utils.enums.MessagesApp.REPORT_DELETED_SUCCESSFULLY_BY_ID;

@Repository
@RequiredArgsConstructor
public class DeleteReportAdapter implements IDeleteReportPersistence {

    private final IReportRepository iReportRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

    @Override
    public String deleteById(UUID id) {

         return this.iReportRepository.findById(id)
                .map(entity -> {

                    String path;

                    if (entity.getReportType().equals(ConstantsApp.TYPE_SALES)) {
                        path = ConstantsApp.PATH_UPLOAD_FILES_PDF_SALES;
                    } else {
                        path = ConstantsApp.PATH_UPLOAD_FILES_PDF_PURCHASES;
                    }

                    this.applicationEventPublisher.publishEvent(new FileDeletedEvent(
                            entity.getFilePath(),
                            path
                    ));

                    this.iReportRepository.deleteById(entity.getId());
                    return REPORT_DELETED_SUCCESSFULLY_BY_ID.format(entity.getId());
                }).orElseThrow(() -> new NotFoundReportException(id));
    }
}
