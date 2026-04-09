package dev.juanleon.supermarket_inventory.files.infrastructure.exterior.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.nio.file.*;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FileUtils implements IFileUtils {

    public void deleteFile(Path path) {
        try {
            Files.deleteIfExists(path);
        } catch (Exception exception) {
            throw new RuntimeException("Error eliminando archivo: " + exception.getMessage());
        }
    }

    @Override
    public void saveFile(InputStream inputStream, Path pathUpload) {
        try {

            Files.copy(
                    inputStream,
                    pathUpload,
                    StandardCopyOption.REPLACE_EXISTING
            );

        } catch (Exception exception) {
            throw new RuntimeException("Error guardando archivo: " + exception.getMessage());
        }
    }

    @Override
    public Optional<Path> findFile(String fileName, String pathUpload) {
        if (fileName == null || fileName.isBlank()) {
            return Optional.empty();
        }

        Path filePath = this.getUploadPath(pathUpload)
                .resolve(fileName)
                .normalize();

        if (Files.exists(filePath) && Files.isRegularFile(filePath)) {
            return Optional.of(filePath);
        }
        return Optional.empty();
    }

    @Override
    public String processAndSaveWebp(InputStream input, String originalName, String pathUpload) {
        InputStream inputStreamImg = this.convertFileImgToWebp(input);
        String nameFileUnique = this.generateUniqueFileName(originalName, "webp");
        Path uploadPath = this.getUploadPath(pathUpload);
        this.createDirectoriesIfNotExists(uploadPath);
        this.saveFile(inputStreamImg, uploadPath.resolve(nameFileUnique));
        return nameFileUnique;
    }
}