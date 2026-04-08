package dev.juanleon.supermarket_inventory.common.utils.files;

import dev.juanleon.supermarket_inventory.common.configuration.AppConfigurationProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.nio.file.*;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class FileUtils implements IFileUtils {

    private final AppConfigurationProperties appConfigurationProperties;

    public void deleteFile(String urlImage) {

        try {

            if (urlImage == null || urlImage.isBlank()) {
                throw new RuntimeException("No existe ningun archivo en la ruta: " + urlImage);
            }

            Path filePath = this.getUploadPath(this.appConfigurationProperties.getPathUploadImagesEmployees())
                    .resolve(urlImage)
                    .normalize();

            Files.deleteIfExists(filePath);

        } catch (Exception exception) {
            throw new RuntimeException("Error eliminando archivo: " + exception.getMessage());
        }
    }

    public String saveFile(MultipartFile file) {

        if (file == null || file.isEmpty()) {
            throw new RuntimeException("El archivo no puede ser nulo");
        }

        String uniqueFileName;

        try {
            InputStream inputStreamImg = this.convertFileImgToWebp(file);

            uniqueFileName = generateUniqueFileName(file);

            Path uploadPath = this.getUploadPath(this.appConfigurationProperties.getPathUploadImagesEmployees());

            this.createDirectoriesIfNotExists(uploadPath);

            Files.copy(
                    inputStreamImg,
                    uploadPath.resolve(uniqueFileName),
                    StandardCopyOption.REPLACE_EXISTING
            );

        } catch (Exception exception) {
            throw new RuntimeException("Error guardando archivo: " + exception.getMessage());
        }

        return uniqueFileName;
    }

    @Override
    public String updateFileExisting(MultipartFile file, String urlImage) {

        if (file == null || file.isEmpty()) {
            throw new RuntimeException("El archivo no puede ser nulo");
        }

        if (urlImage == null || urlImage.isBlank()) {
            throw new RuntimeException("No existe ningun archivo en la ruta: " + urlImage);
        }

        String uniqueFileName;

        try {

            InputStream inputStreamImg = this.convertFileImgToWebp(file);

            uniqueFileName = urlImage;

            Path uploadPath = this.getUploadPath(this.appConfigurationProperties.getPathUploadImagesEmployees());

            Files.copy(
                    inputStreamImg,
                    uploadPath.resolve(uniqueFileName),
                    StandardCopyOption.REPLACE_EXISTING
            );

        } catch (Exception exception) {
            throw new RuntimeException("Error guardando archivo: " + exception.getMessage());
        }
        return uniqueFileName;
    }
}