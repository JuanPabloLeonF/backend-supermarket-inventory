package dev.juanleon.supermarket_inventory.files.infrastructure.exterior.repository;

import com.sksamuel.scrimage.ImmutableImage;
import com.sksamuel.scrimage.webp.WebpWriter;
import dev.juanleon.supermarket_inventory.files.infrastructure.exceptions.ErrorConvertingImageToWebpException;
import dev.juanleon.supermarket_inventory.files.infrastructure.exceptions.ErrorCreatedDirectoriesException;
import dev.juanleon.supermarket_inventory.files.infrastructure.exceptions.ErrorFileTypeNotAllowedException;
import dev.juanleon.supermarket_inventory.files.infrastructure.exceptions.ErrorTryingDeleteFileException;
import org.springframework.util.StringUtils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

public interface IFileUtils {

    void saveFile(InputStream inputStream, Path pathUpload);
    String processAndSaveWebp(InputStream input, String originalName, String pathUpload);
    Optional<Path> findFile(String fileName, String pathUpload);
    InputStream convertHtmlToPdf(String processedHtml);

    default void validateContentType(String contentType, List<String> allowedTypes) {
        if (contentType == null || !allowedTypes.contains(contentType)) {
            throw new ErrorFileTypeNotAllowedException(contentType);
        }
    }

    default void deleteFileByPath(Path path) {
        try {
            Files.deleteIfExists(path);
        } catch (IOException exception) {
            throw new ErrorTryingDeleteFileException(exception.getMessage());
        }
    }

    default InputStream convertFileImgToWebp(InputStream inputStream) {
        try {
            byte[] webpBytes = ImmutableImage.loader()
                    .fromStream(inputStream)
                    .bytes(WebpWriter.DEFAULT);
            return new ByteArrayInputStream(webpBytes);
        } catch (Exception exception) {
            throw new ErrorConvertingImageToWebpException(exception.getMessage());
        }
    }

    default String generateUniqueFileName(String originalName, String extension) {
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(originalName));
        String nameWithoutExtension = fileName.contains(".")
                ? fileName.substring(0, fileName.lastIndexOf('.'))
                : fileName;
        return UUID.randomUUID() + "_" + nameWithoutExtension + "." + extension;
    }

    default Path getUploadPath(String urlPath) {
        return Path.of(urlPath);
    }

    default void createDirectoriesIfNotExists(Path path) {
        if (!Files.exists(path)) {
            try {
                Files.createDirectories(path);
            } catch (IOException exception) {
                throw new ErrorCreatedDirectoriesException(exception.getMessage());
            }
        }
    }
}
