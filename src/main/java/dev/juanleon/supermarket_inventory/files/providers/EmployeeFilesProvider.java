package dev.juanleon.supermarket_inventory.files.providers;

import dev.juanleon.supermarket_inventory.common.utils.dto.InputFileDto;
import dev.juanleon.supermarket_inventory.files.services.DeleteFileService;
import dev.juanleon.supermarket_inventory.files.services.ImageStoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmployeeFilesProvider implements IFilesProviderExample {

    private final ImageStoreService imageStoreService;
    private final DeleteFileService deleteFileService;

    @Override
    public String createImg(InputFileDto inputFileDto, String pathUpload) {
        return this.imageStoreService.storeImage(inputFileDto, pathUpload);
    }

    @Override
    public String deleteImage(String urlImg, String pathUpload) {
        return this.deleteFileService.deleteFile(urlImg, pathUpload);
    }
}
