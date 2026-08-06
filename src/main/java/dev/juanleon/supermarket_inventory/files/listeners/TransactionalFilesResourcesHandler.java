package dev.juanleon.supermarket_inventory.files.listeners;

import dev.juanleon.supermarket_inventory.files.events.FileCreatedEvent;
import dev.juanleon.supermarket_inventory.files.events.FileDeletedEvent;
import dev.juanleon.supermarket_inventory.files.storage.FileStorage;
import dev.juanleon.supermarket_inventory.files.utils.FilesUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import java.nio.file.Path;

@Slf4j
@Component
@RequiredArgsConstructor
public class TransactionalFilesResourcesHandler {

    private final FileStorage fileStorage;

    @TransactionalEventListener(phase = TransactionPhase.AFTER_ROLLBACK)
    public void handlerFileCreatedRollback(FileCreatedEvent event) {
        log.warn("Transaccion fallida detectada. limpiando archivo en rollback: {}", event.urlFile());
        Path path = FilesUtil.stringToPath(event.pathUpload());
        this.fileStorage.findFile(event.urlFile(), path)
                .ifPresent(this.fileStorage::deleteFileByPath);
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void handlerFileDeleted(FileDeletedEvent event) {
        log.info("Transaccion exitosa detectada. limpiando archivo en commit: {}", event.urlFile());
        Path path = FilesUtil.stringToPath(event.pathUpload());
        this.fileStorage.findFile(event.urlFile(), path)
                .ifPresent(this.fileStorage::deleteFileByPath);
    }
}
