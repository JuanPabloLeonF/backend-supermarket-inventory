package dev.juanleon.supermarket_inventory.share.files.storage;

import dev.juanleon.supermarket_inventory.share.files.exceptions.ErrorCreatedDirectoriesException;
import dev.juanleon.supermarket_inventory.share.files.exceptions.ErrorTryingDeleteFileException;
import dev.juanleon.supermarket_inventory.share.files.exceptions.ErrorTryingSaveFileException;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Optional;

@Component
public class FileStorage {

    public void storeFile(InputStream inputStream, Path path) {
        try {
            Files.copy(
                    inputStream,
                    path,
                    StandardCopyOption.REPLACE_EXISTING
            );

        } catch (Exception exception) {
            throw new ErrorTryingSaveFileException(exception.getMessage());
        }
    }

    public Optional<Path> findFile(String fileName, Path path) {

        if (fileName == null || fileName.isBlank()) {
            return Optional.empty();
        }

        Path filePath = path
                .resolve(fileName)
                .normalize();

        if (Files.exists(filePath) && Files.isRegularFile(filePath)) {
            return Optional.of(filePath);
        }

        return Optional.empty();
    }

    public void deleteFileByPath(Path path) {
        try {
            Files.deleteIfExists(path);
        } catch (IOException exception) {
            throw new ErrorTryingDeleteFileException(exception.getMessage());
        }
    }

    public void createDirectoriesIfNotExists(Path path) {
        if (!Files.exists(path)) {
            try {
                Files.createDirectories(path);
            } catch (IOException exception) {
                throw new ErrorCreatedDirectoriesException(exception.getMessage());
            }
        }
    }
}
