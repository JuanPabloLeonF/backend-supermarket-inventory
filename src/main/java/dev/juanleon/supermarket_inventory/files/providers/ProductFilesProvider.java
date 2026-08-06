package dev.juanleon.supermarket_inventory.files.providers;

import dev.juanleon.supermarket_inventory.common.utils.dto.InputFileDto;
import dev.juanleon.supermarket_inventory.files.services.ImageStoreService;
import dev.juanleon.supermarket_inventory.products.domain.ports.IFilesProviderProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductFilesProvider implements IFilesProviderProduct {

    private final ImageStoreService imageStoreService;

    @Override
    public String createImage(InputFileDto inputFileDto, String uploadUrl) {
        return this.imageStoreService.storeImage(inputFileDto, uploadUrl);
    }
}
