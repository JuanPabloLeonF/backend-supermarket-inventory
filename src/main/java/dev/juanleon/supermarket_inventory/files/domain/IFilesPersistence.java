package dev.juanleon.supermarket_inventory.files.domain;

import dev.juanleon.supermarket_inventory.common.utils.dto.InputFileDto;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.reports.domain.models.SaleReportDto;

import java.util.List;

public interface IFilesPersistence {
    String createPdf(SaleReportDto saleReportDto, String pathUpload, String templateName);
    String createImage(InputFileDto inputFileDto, String pathUpload);
    String updateImg(InputFileDto inputFileDto, String pathUpload, String urlImage);
    ResponseModel deleteFile(String urlImage, String pathUpload);
    void validateContentType(String contentType, List<String> allowedExtensions);
}
