package dev.juanleon.supermarket_inventory.common.utils.files;

import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

public interface IFileUtils {

    void deleteFile(String urlImage);
    String saveFile(MultipartFile file);

    default String generateUniqueFileName(String fileName) {
        return UUID.randomUUID() + "_" + fileName;
    }

    default Path getUploadPath(String urlPath) {
        return Path.of(urlPath);
    }

    default void createDirectoriesIfNotExists(Path path) throws Exception {
        if (!Files.exists(path)) {
            Files.createDirectories(path);
        }
    }
}
