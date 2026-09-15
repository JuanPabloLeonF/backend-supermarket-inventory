package dev.juanleon.supermarket_inventory.share.files.providers;

import dev.juanleon.supermarket_inventory.modules.products.domain.ports.IFilesProviderProduct;
import dev.juanleon.supermarket_inventory.share.configuration.ConstantsApp;
import dev.juanleon.supermarket_inventory.share.files.services.ImageStoreService;
import dev.juanleon.supermarket_inventory.share.utils.dto.InputFileDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class ProductFilesProvider implements IFilesProviderProduct {

    private final ImageStoreService service;

    @Override
    public String uploadImage(InputFileDto inputFileDto) {
        return this.service.uploadImage(inputFileDto, ConstantsApp.PATH_UPLOAD_IMAGES_PRODUCTS);
    }
}
