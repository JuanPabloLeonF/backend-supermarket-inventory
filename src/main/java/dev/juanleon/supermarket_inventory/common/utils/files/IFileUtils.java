package dev.juanleon.supermarket_inventory.common.utils.files;

import com.sksamuel.scrimage.ImmutableImage;
import com.sksamuel.scrimage.webp.WebpWriter;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
import java.util.UUID;

public interface IFileUtils {

    void deleteFile(String urlImage);
    String saveFile(MultipartFile file);
    String updateFileExisting(MultipartFile file, String urlImage);

    default InputStream convertFileImgToWebp(MultipartFile file) {
        try {
            byte[] webpBytes = ImmutableImage.loader()
                    .fromStream(file.getInputStream())
                    .bytes(WebpWriter.DEFAULT);

            return new ByteArrayInputStream(webpBytes);
        } catch (Exception e) {
            throw new RuntimeException("Fallo al convertir imagen a WebP: " + e.getMessage());
        }
    }

    default String generateUniqueFileName(MultipartFile file) {
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        String nameWithoutExtension = fileName.contains(".")
                ? fileName.substring(0, fileName.lastIndexOf('.'))
                : fileName;
        return UUID.randomUUID() + "_" + nameWithoutExtension + ".webp";
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
