package dev.juanleon.supermarket_inventory.share.files.services;

import dev.juanleon.supermarket_inventory.share.utils.dto.InputFileDto;
import dev.juanleon.supermarket_inventory.share.files.events.FileCreatedEvent;
import dev.juanleon.supermarket_inventory.share.files.storage.FileStorage;
import dev.juanleon.supermarket_inventory.share.files.utils.FileConstants;
import dev.juanleon.supermarket_inventory.share.files.utils.FilesUtil;
import dev.juanleon.supermarket_inventory.share.files.validators.FilesValidations;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.nio.file.Path;

@Service
@RequiredArgsConstructor
public class ImageStoreService {

    private final FileStorage fileStorage;
    private final ApplicationEventPublisher applicationEventPublisher;

    public String storeImage(InputFileDto inputFileDto, String uploadUrl) {

        FilesValidations.validateContentType(
                inputFileDto.getContentType(),
                FileConstants.ALLOWED_IMAGE_EXTENSIONS
        );

        Path path = FilesUtil.stringToPath(uploadUrl);

        this.fileStorage.createDirectoriesIfNotExists(path);

        String fileName = FilesUtil.generateUniqueFileName(
                inputFileDto.getOriginalName(),
                FileConstants.WEBP
        );

        InputStream inputStream = FilesUtil.convertFileImgToWebp(inputFileDto.getInputStream());

        this.fileStorage.storeFile(inputStream, path.resolve(fileName));

        this.applicationEventPublisher.publishEvent(new FileCreatedEvent(fileName, uploadUrl));

        return fileName;
    }
}
