package dev.juanleon.supermarket_inventory.files.domain;

import dev.juanleon.supermarket_inventory.common.configuration.AppConfigurationProperties;
import dev.juanleon.supermarket_inventory.common.utils.dto.InputFileDto;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseModel;

public class FilesUseCase implements IFilesService {

    private final IFilesPersistence iFilesPersistence;
    private final AppConfigurationProperties appConfigurationProperties;

    public FilesUseCase(IFilesPersistence iFilesPersistence, AppConfigurationProperties appConfigurationProperties) {
        this.iFilesPersistence = iFilesPersistence;
        this.appConfigurationProperties = appConfigurationProperties;
    }

    @Override
    public String createPdf(InputFileDto inputFileDto) {
        return this.iFilesPersistence.createPdf(inputFileDto, this.appConfigurationProperties.getPathUploadFilesPdfReports());
    }

    @Override
    public String createImage(InputFileDto inputFileDto) {
        return this.iFilesPersistence.createImage(inputFileDto, this.appConfigurationProperties.getPathUploadImagesEmployees());
    }

    @Override
    public String updateFile(InputFileDto inputFileDto, String urlImage) {
        return this.iFilesPersistence.updateImg(inputFileDto, this.appConfigurationProperties.getPathUploadImagesEmployees(), urlImage);
    }

    @Override
    public ResponseModel deleteFile(String urlImage) {
        return this.iFilesPersistence.deleteFile(urlImage, this.appConfigurationProperties.getPathUploadImagesEmployees());
    }
}
