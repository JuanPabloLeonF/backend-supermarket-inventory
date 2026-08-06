package dev.juanleon.supermarket_inventory.files.services;

import dev.juanleon.supermarket_inventory.files.exceptions.NotFoundFileException;
import dev.juanleon.supermarket_inventory.files.storage.FileStorage;
import dev.juanleon.supermarket_inventory.files.utils.FilesUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.nio.file.Path;

import static dev.juanleon.supermarket_inventory.common.utils.enums.MessagesApp.File_DELETED_SUCCESSFULLY_BY_URL;

@Service
@RequiredArgsConstructor
public class DeleteFileService {

    private final FileStorage fileStorage;
    private final ApplicationEventPublisher applicationEventPublisher;

    public String deleteFile(String urlFile, String pathUpload) {

        Path path = FilesUtil.stringToPath(pathUpload);

        return this.fileStorage.findFile(urlFile, path)
                .map(file -> {
                    this.fileStorage.deleteFileByPath(file);
                    return File_DELETED_SUCCESSFULLY_BY_URL.format(urlFile);
                }).orElseThrow(() -> new NotFoundFileException(urlFile));
    }
}
