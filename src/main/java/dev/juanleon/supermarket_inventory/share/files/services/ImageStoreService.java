package dev.juanleon.supermarket_inventory.share.files.services;

import dev.juanleon.supermarket_inventory.share.configuration.ConstantsApp;
import dev.juanleon.supermarket_inventory.share.files.storage.ports.IFilesStore;
import dev.juanleon.supermarket_inventory.share.files.utils.FilesValidations;
import dev.juanleon.supermarket_inventory.share.utils.dto.InputFileDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ImageStoreService {

    @Qualifier("cloudinaryAdapter")
    private final IFilesStore store;

    public ImageStoreService(IFilesStore store) {
        this.store = store;
    }

    public String uploadImage(InputFileDto inputFileDto, String folderName) {
        FilesValidations.validateContentType(
                inputFileDto.getContentType(),
                ConstantsApp.ALLOWED_IMAGE_EXTENSIONS
        );
        return this.store.uploadImage(inputFileDto, folderName);
    }
}
