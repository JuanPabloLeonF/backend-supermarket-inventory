package dev.juanleon.supermarket_inventory.files.domain;

import dev.juanleon.supermarket_inventory.common.utils.dto.InputFileDto;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.reports.domain.models.SaleReportModel;

import java.util.List;

public interface IFilesPersistence {
    String createPdf(SaleReportModel saleReportModel, String pathUpload, String templateName);
    String createImage(InputFileDto inputFileDto, String pathUpload);
    String updateImg(InputFileDto inputFileDto, String pathUpload, String urlImage);
    ResponseModel deleteFile(String urlFile, String pathUpload);
    void validateContentType(String contentType, List<String> allowedExtensions);
}
