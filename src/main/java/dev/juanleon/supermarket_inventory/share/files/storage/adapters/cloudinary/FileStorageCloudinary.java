package dev.juanleon.supermarket_inventory.share.files.storage.adapters.cloudinary;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import dev.juanleon.supermarket_inventory.share.files.events.FileCreatedEvent;
import dev.juanleon.supermarket_inventory.share.files.exceptions.ErrorTryingDeleteFileException;
import dev.juanleon.supermarket_inventory.share.files.exceptions.ErrorTryingSaveFileException;
import dev.juanleon.supermarket_inventory.share.files.storage.ports.IFilesStore;
import dev.juanleon.supermarket_inventory.share.files.utils.FilesUtil;
import dev.juanleon.supermarket_inventory.share.utils.dto.InputFileDto;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.io.InputStream;


@Component("cloudinaryAdapter")
@RequiredArgsConstructor
public class FileStorageCloudinary implements IFilesStore {

    private final Cloudinary cloudinary;
    private final ApplicationEventPublisher applicationEventPublisher;


    @Override
    public String uploadImage(InputFileDto inputFileDto, String folderName) {
        try (InputStream inputStream = inputFileDto.getInputStream()) {

            byte[] fileBytes = inputStream.readAllBytes();

            var options = ObjectUtils.asMap(
                    "folder", folderName,
                    "format", "webp",
                    "resource_type", "image"
            );

            var uploadResult = this.cloudinary.uploader().upload(fileBytes, options);

            String secureUrl = uploadResult.get("secure_url").toString();

            this.applicationEventPublisher.publishEvent(new FileCreatedEvent(secureUrl));

            return secureUrl;
        } catch (Exception exception) {
            throw new ErrorTryingSaveFileException(exception.getMessage());
        }
    }

    @Override
    public void deleteFile(String urlFile) {
        try {
            String publicId = FilesUtil.extractPublicIdFromUrl(urlFile);
            String resourceType = FilesUtil.determineResourceType(urlFile);

            var options = ObjectUtils.asMap(
                    "resource_type", resourceType,
                    "invalidate", true
            );

            var result = this.cloudinary.uploader().destroy(publicId, options);

            if (!"ok".equals(result.get("result"))) {
                throw new ErrorTryingDeleteFileException("No se pudo eliminar el archivo (" + resourceType + ") en Cloudinary: " + publicId);
            }

        } catch (Exception exception) {
            throw new ErrorTryingDeleteFileException(exception.getMessage());
        }
    }

    @Override
    public String uploadPdf(InputStream inputStream, String folderName) {
        try (inputStream) {

            byte[] fileBytes = inputStream.readAllBytes();

            var options = ObjectUtils.asMap(
                    "folder", folderName,
                    "format", "pdf",
                    "resource_type", "raw"
            );

            var uploadResult = this.cloudinary.uploader().upload(fileBytes, options);

            return uploadResult.get("secure_url").toString();
        } catch (Exception exception) {
            throw new ErrorTryingSaveFileException(exception.getMessage());
        }
    }



}
