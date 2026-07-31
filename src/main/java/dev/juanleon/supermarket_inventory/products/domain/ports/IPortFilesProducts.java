package dev.juanleon.supermarket_inventory.products.domain.ports;

import dev.juanleon.supermarket_inventory.common.utils.dto.InputFileDto;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseModel;

public interface IPortFilesProducts {
    String createImage(InputFileDto inputFileDto, String uploadUrl);
    ResponseModel deleteImage(String urlFile, String uploadUrl);
}
