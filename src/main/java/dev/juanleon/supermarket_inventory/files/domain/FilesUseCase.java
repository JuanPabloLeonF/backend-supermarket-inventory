package dev.juanleon.supermarket_inventory.files.domain;

import dev.juanleon.supermarket_inventory.common.utils.dto.InputFileDto;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.reports.domain.models.SaleReportModel;

import static dev.juanleon.supermarket_inventory.files.domain.FileConstants.ALLOWED_IMAGE_EXTENSIONS;

public class FilesUseCase implements IFilesService {

    private final IFilesPersistence iFilesPersistence;

    public FilesUseCase(IFilesPersistence iFilesPersistence) {
        this.iFilesPersistence = iFilesPersistence;
    }

    @Override
    public String createPdf(SaleReportModel saleReportModel, String templateName, String uploadUrl) {
        return this.iFilesPersistence.createPdf(
                saleReportModel,
                uploadUrl,
                templateName
        );
    }

    @Override
    public String createImage(InputFileDto inputFileDto, String uploadUrl) {
        this.iFilesPersistence.validateContentType(inputFileDto.getContentType(), ALLOWED_IMAGE_EXTENSIONS);
        return this.iFilesPersistence.createImage(inputFileDto, uploadUrl);
    }

    @Override
    public String updateImg(InputFileDto inputFileDto, String urlImage, String uploadUrl) {
        this.iFilesPersistence.validateContentType(inputFileDto.getContentType(), ALLOWED_IMAGE_EXTENSIONS);
        return this.iFilesPersistence.updateImg(inputFileDto, uploadUrl, urlImage);
    }

    @Override
    public ResponseModel deleteReportSales(String urlFile, String uploadUrl) {
        return this.iFilesPersistence.deleteFile(urlFile, uploadUrl);
    }

    @Override
    public ResponseModel deleteImage(String urlFile, String uploadUrl) {
        return this.iFilesPersistence.deleteFile(urlFile, uploadUrl);
    }
}
