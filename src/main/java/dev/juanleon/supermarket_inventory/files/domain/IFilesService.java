package dev.juanleon.supermarket_inventory.files.domain;

import dev.juanleon.supermarket_inventory.common.utils.dto.InputFileDto;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.reports.domain.models.SaleReportDto;

public interface IFilesService {
    String createPdf(SaleReportDto saleReportDto, String templateName, String uploadPath);
    String createImage(InputFileDto inputFileDto);
    String updateFile(InputFileDto inputFileDto, String urlImage);
    ResponseModel deleteFile(String urlImage);
}
