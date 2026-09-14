package dev.juanleon.supermarket_inventory.share.files.services;

import dev.juanleon.supermarket_inventory.share.files.storage.FileStorageCloudinary;
import dev.juanleon.supermarket_inventory.share.utils.dto.InputFileDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImageStoreCloudinaryService {

    private final FileStorageCloudinary fileStoreCloudinary;

    public String uploadImage(InputFileDto inputFileDto, String folderName) {
        return this.fileStoreCloudinary.uploadImage(inputFileDto, folderName);
    }

    public String deleteImage(String urlImg) {
        return this.fileStoreCloudinary.deleteImage(urlImg);
    }
}
