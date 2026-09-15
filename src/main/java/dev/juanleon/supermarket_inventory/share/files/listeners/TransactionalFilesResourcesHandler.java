package dev.juanleon.supermarket_inventory.share.files.listeners;

import dev.juanleon.supermarket_inventory.share.files.events.FileCreatedEvent;
import dev.juanleon.supermarket_inventory.share.files.events.FileDeletedEvent;
import dev.juanleon.supermarket_inventory.share.files.storage.ports.IFilesStore;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
@Component
public class TransactionalFilesResourcesHandler {

    @Qualifier("cloudinaryAdapter")
    private final IFilesStore storage;

    public TransactionalFilesResourcesHandler(IFilesStore storage) {
        this.storage = storage;
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_ROLLBACK)
    public void handlerFileCreatedRollback(FileCreatedEvent event) {
        log.warn("Transaccion fallida detectada. limpiando archivo en el store: {}", event.urlFile());
        this.storage.deleteFile(event.urlFile());
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void handlerFileDeletedNew(FileDeletedEvent event) {
        log.info("Transaccion exitosa detectada. limpiando archivo en el store: {}", event.urlFile());
        this.storage.deleteFile(event.urlFile());
    }
}
