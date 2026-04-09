package dev.juanleon.supermarket_inventory.files.domain;

import dev.juanleon.supermarket_inventory.common.utils.dto.InputFileDto;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseModel;

public interface IFilesService {
    String createPdf(InputFileDto inputFileDto);
    String createImage(InputFileDto inputFileDto);
    String updateFile(InputFileDto inputFileDto, String urlImage);
    ResponseModel deleteFile(String urlImage);
}
