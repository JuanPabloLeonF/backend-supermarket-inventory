package dev.juanleon.supermarket_inventory.files.application;

import dev.juanleon.supermarket_inventory.common.utils.dto.InputFileDto;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.employees.domain.ports.IPortFilesEmployee;
import dev.juanleon.supermarket_inventory.files.domain.IFilesService;
import dev.juanleon.supermarket_inventory.products.domain.ports.IPortFilesProducts;
import dev.juanleon.supermarket_inventory.reports.domain.models.SaleReportModel;
import dev.juanleon.supermarket_inventory.reports.domain.ports.IPortFilesReports;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FilesHandler implements
        IPortFilesEmployee,
        IPortFilesReports,
        IPortFilesProducts
{

    private final IFilesService iFilesService;

    @Override
    public String createImage(InputFileDto inputFileDto, String uploadUrl) {
        return this.iFilesService.createImage(inputFileDto, uploadUrl);
    }

    @Override
    public ResponseModel deleteImage(String urlFile, String uploadUrl) {
        return this.iFilesService.deleteImage(urlFile, uploadUrl);
    }

    @Override
    public String updateImg(InputFileDto inputFileDto, String urlImage, String uploadUrl) {
        return this.iFilesService.updateImg(inputFileDto, urlImage, uploadUrl);
    }

    @Override
    public ResponseModel deleteReportSales(String urlFile, String uploadUrl) {
        return this.iFilesService.deleteReportSales(urlFile, uploadUrl);
    }

    @Override
    public String createPdf(SaleReportModel saleReportModel, String templateName, String uploadUrl) {
        return this.iFilesService.createPdf(saleReportModel, templateName, uploadUrl);
    }
}
