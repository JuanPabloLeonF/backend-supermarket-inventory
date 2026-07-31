package dev.juanleon.supermarket_inventory.employees.domain.ports;

import dev.juanleon.supermarket_inventory.common.utils.dto.InputFileDto;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseModel;

public interface IPortFilesEmployee {
    String createImage(InputFileDto inputFileDto, String uploadUrl);
    ResponseModel deleteImage(String urlFile, String uploadUrl);
    String updateImg(InputFileDto inputFileDto, String urlImage, String uploadUrl);
}
