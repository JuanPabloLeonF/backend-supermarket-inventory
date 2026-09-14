package dev.juanleon.supermarket_inventory.share.files.storage;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import dev.juanleon.supermarket_inventory.share.files.exceptions.ErrorTryingDeleteFileException;
import dev.juanleon.supermarket_inventory.share.files.exceptions.ErrorTryingSaveFileException;
import dev.juanleon.supermarket_inventory.share.utils.dto.InputFileDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.InputStream;

import static dev.juanleon.supermarket_inventory.share.utils.enums.MessagesApp.File_DELETED_SUCCESSFULLY_BY_URL;

@Component
@RequiredArgsConstructor
public class FileStorageCloudinary {

    private final Cloudinary cloudinary;

    public String uploadImage(InputFileDto inputFileDto, String folderName) {
        try (InputStream inputStream = inputFileDto.getInputStream()) {

            byte[] fileBytes = inputStream.readAllBytes();

            var options = ObjectUtils.asMap(
                    "folder", folderName,
                    "format", "webp",
                    "resource_type", "image"
            );

            var uploadResult = this.cloudinary.uploader().upload(fileBytes, options);

            return uploadResult.get("secure_url").toString();
        } catch (Exception exception) {
            throw new ErrorTryingSaveFileException(exception.getMessage());
        }
    }

    public String deleteImage(String urlImg) {
        try {

            String publicId = extractPublicIdFromUrl(urlImg);

            var result = this.cloudinary.uploader().destroy(publicId, ObjectUtils.emptyMap());

            if (!"ok".equals(result.get("result"))) {
                throw new ErrorTryingDeleteFileException("No se pudo eliminar la imagen en Cloudinary: " + publicId);
            }

            return File_DELETED_SUCCESSFULLY_BY_URL.format(urlImg);

        } catch (Exception exception) {
            throw new ErrorTryingDeleteFileException(exception.getMessage());
        }
    }

    public static String extractPublicIdFromUrl(String imageUrl) {
        if (imageUrl == null || imageUrl.isBlank()) {
            throw new IllegalArgumentException("La URL de la imagen no puede estar vacía.");
        }

        try {
            String pathAfterUpload = imageUrl.substring(imageUrl.indexOf("/upload/") + 8);

            if (pathAfterUpload.startsWith("v") && pathAfterUpload.contains("/")) {
                pathAfterUpload = pathAfterUpload.substring(pathAfterUpload.indexOf("/") + 1);
            }

            int lastDotIndex = pathAfterUpload.lastIndexOf(".");
            if (lastDotIndex != -1) {
                pathAfterUpload = pathAfterUpload.substring(0, lastDotIndex);
            }

            return pathAfterUpload;
        } catch (Exception e) {
            throw new IllegalArgumentException("No se pudo extraer el public_id de la URL de Cloudinary: " + imageUrl, e);
        }
    }

}
