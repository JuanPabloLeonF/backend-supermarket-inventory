package dev.juanleon.supermarket_inventory.files.providers;

import dev.juanleon.supermarket_inventory.common.utils.dto.InputFileDto;

public interface IFilesProviderExample {
    String createImg(InputFileDto inputFileDto, String pathUpload);
    String deleteImage(String urlImg, String pathUpload);
}
