package dev.juanleon.supermarket_inventory.common.utils.files;

import dev.juanleon.supermarket_inventory.common.configuration.AppConfigurationProperties;
import dev.juanleon.supermarket_inventory.common.utils.dto.InputFileDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.nio.file.*;

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

    public String saveFile(InputFileDto file) {
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
    public String updateFileExisting(InputFileDto file, String urlImage) {

        if (urlImage == null || urlImage.isBlank()) {
            throw new RuntimeException("No existe ningun archivo en la ruta: " + urlImage);
        }

        String uniqueFileName;

        try {

            InputStream inputStreamImg = this.convertFileImgToWebp(file);

            uniqueFileName = generateUniqueFileName(file);

            Path uploadPath = this.getUploadPath(this.appConfigurationProperties.getPathUploadImagesEmployees());

            Files.copy(
                    inputStreamImg,
                    uploadPath.resolve(uniqueFileName),
                    StandardCopyOption.REPLACE_EXISTING
            );

            this.deleteFile(urlImage);

        } catch (Exception exception) {
            throw new RuntimeException("Error guardando archivo: " + exception.getMessage());
        }
        return uniqueFileName;
    }
}