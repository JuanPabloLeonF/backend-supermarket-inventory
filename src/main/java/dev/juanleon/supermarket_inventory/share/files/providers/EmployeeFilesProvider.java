package dev.juanleon.supermarket_inventory.share.files.providers;

import dev.juanleon.supermarket_inventory.share.configuration.ConstantsApp;
import dev.juanleon.supermarket_inventory.share.files.services.ImageStoreService;
import dev.juanleon.supermarket_inventory.share.utils.dto.InputFileDto;
import dev.juanleon.supermarket_inventory.modules.employees.domain.ports.IFilesProviderEmployee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmployeeFilesProvider implements IFilesProviderEmployee {

    private final ImageStoreService service;

    @Override
    public String uploadImage(InputFileDto inputFileDto) {
        return this.service.uploadImage(inputFileDto, ConstantsApp.PATH_UPLOAD_IMAGES_EMPLOYEES);
    }
}
