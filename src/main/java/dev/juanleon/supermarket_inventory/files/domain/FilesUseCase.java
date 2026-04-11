package dev.juanleon.supermarket_inventory.files.domain;

import dev.juanleon.supermarket_inventory.common.configuration.AppConfigurationProperties;
import dev.juanleon.supermarket_inventory.common.utils.dto.InputFileDto;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.reports.domain.models.SaleReportModel;

import static dev.juanleon.supermarket_inventory.files.domain.FileConstants.ALLOWED_IMAGE_EXTENSIONS;

public class FilesUseCase implements IFilesService {

    private final IFilesPersistence iFilesPersistence;
    private final AppConfigurationProperties appConfigurationProperties;

    public FilesUseCase(IFilesPersistence iFilesPersistence, AppConfigurationProperties appConfigurationProperties) {
        this.iFilesPersistence = iFilesPersistence;
        this.appConfigurationProperties = appConfigurationProperties;
    }

    @Override
    public String createPdf(SaleReportModel saleReportModel, String templateName) {
        return this.iFilesPersistence.createPdf(
                saleReportModel,
                this.appConfigurationProperties.getPathUploadFilesPdfReportsSales(),
                templateName
        );
    }

    @Override
    public String createImage(InputFileDto inputFileDto) {
        this.iFilesPersistence.validateContentType(inputFileDto.getContentType(), ALLOWED_IMAGE_EXTENSIONS);
        return this.iFilesPersistence.createImage(inputFileDto, this.appConfigurationProperties.getPathUploadImagesEmployees());
    }

    @Override
    public String updateFile(InputFileDto inputFileDto, String urlImage) {
        this.iFilesPersistence.validateContentType(inputFileDto.getContentType(), ALLOWED_IMAGE_EXTENSIONS);
        return this.iFilesPersistence.updateImg(inputFileDto, this.appConfigurationProperties.getPathUploadImagesEmployees(), urlImage);
    }

    @Override
    public ResponseModel deleteFile(String urlImage) {
        return this.iFilesPersistence.deleteFile(urlImage, this.appConfigurationProperties.getPathUploadImagesEmployees());
    }
}
