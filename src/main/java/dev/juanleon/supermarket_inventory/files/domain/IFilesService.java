package dev.juanleon.supermarket_inventory.files.domain;

import dev.juanleon.supermarket_inventory.common.utils.dto.InputFileDto;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.reports.domain.models.SaleReportModel;

public interface IFilesService {
    String createPdf(SaleReportModel saleReportModel, String templateName, String uploadUrl);
    String createImage(InputFileDto inputFileDto, String uploadUrl);
    String updateImg(InputFileDto inputFileDto, String urlImage, String uploadUrl);
    ResponseModel deleteReportSales(String urlFile, String uploadUrl);
    ResponseModel deleteImage(String urlFile, String uploadUrl);
}
