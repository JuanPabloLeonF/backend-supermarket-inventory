package dev.juanleon.supermarket_inventory.modules.products.domain.ports;

import dev.juanleon.supermarket_inventory.share.utils.dto.InputFileDto;

public interface IFilesProviderProductPrueba {
    String uploadImage(InputFileDto inputFileDto, String folderName);
    String deleteImage(String urlImg);
}
