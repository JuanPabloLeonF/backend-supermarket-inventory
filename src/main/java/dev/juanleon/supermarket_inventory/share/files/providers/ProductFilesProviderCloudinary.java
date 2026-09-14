package dev.juanleon.supermarket_inventory.share.files.providers;

import dev.juanleon.supermarket_inventory.modules.products.domain.ports.IFilesProviderProductPrueba;
import dev.juanleon.supermarket_inventory.share.files.services.ImageStoreCloudinaryService;
import dev.juanleon.supermarket_inventory.share.utils.dto.InputFileDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductFilesProviderCloudinary implements IFilesProviderProductPrueba {

    private final ImageStoreCloudinaryService service;

    @Override
    public String uploadImage(InputFileDto inputFileDto, String folderName) {
        return this.service.uploadImage(inputFileDto, folderName);
    }

    @Override
    public String deleteImage(String urlImg) {
        return this.service.deleteImage(urlImg);
    }
}
