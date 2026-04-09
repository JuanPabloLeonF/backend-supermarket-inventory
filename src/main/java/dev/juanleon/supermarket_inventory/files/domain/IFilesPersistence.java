package dev.juanleon.supermarket_inventory.files.domain;

import dev.juanleon.supermarket_inventory.common.utils.dto.InputFileDto;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseModel;

public interface IFilesPersistence {
    String createPdf(InputFileDto inputFileDto, String pathUpload);
    String createImage(InputFileDto inputFileDto, String pathUpload);
    String updateImg(InputFileDto inputFileDto, String pathUpload, String urlImage);
    ResponseModel deleteFile(String urlImage, String pathUpload);
}
