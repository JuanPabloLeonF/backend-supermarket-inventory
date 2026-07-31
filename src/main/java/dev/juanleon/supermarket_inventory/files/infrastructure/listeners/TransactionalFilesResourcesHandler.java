package dev.juanleon.supermarket_inventory.files.infrastructure.listeners;

import dev.juanleon.supermarket_inventory.files.domain.events.FileCreatedEvent;
import dev.juanleon.supermarket_inventory.files.infrastructure.exterior.repository.IFileUtils;
import dev.juanleon.supermarket_inventory.products.domain.events.UpdateUrlImgProductEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
@Component
@RequiredArgsConstructor
public class TransactionalFilesResourcesHandler {

    private final IFileUtils iFilesUtils;

    @TransactionalEventListener(phase = TransactionPhase.AFTER_ROLLBACK)
    public void handlerFileCreatedRollback(FileCreatedEvent event) {
        log.warn("Transaccion fallida detectada. limpiando archivo en rollback: {}", event.urlFile());
        this.iFilesUtils.findFile(event.urlFile(), event.pathUpload())
                .ifPresent(this.iFilesUtils::deleteFileByPath);
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void handlerFileUpdated(UpdateUrlImgProductEvent event) {
        log.info("Transaccion exitosa detectada. limpiando archivo antiguo en commit: {}", event.urlImgOld());
        this.iFilesUtils.findFile(event.urlImgOld(), event.uploadUrl())
                .ifPresent(this.iFilesUtils::deleteFileByPath);
    }
}
