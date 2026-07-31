package dev.juanleon.supermarket_inventory.employees.domain.ports;

import dev.juanleon.supermarket_inventory.common.utils.dto.InputFileDto;

public interface IPortFilesEmployee {
    String createImage(InputFileDto inputFileDto, String uploadUrl);
}
