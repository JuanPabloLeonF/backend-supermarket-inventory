package dev.juanleon.supermarket_inventory.modules.employees.domain.ports;

import dev.juanleon.supermarket_inventory.share.utils.dto.InputFileDto;

public interface IFilesProviderEmployee {
    String createImage(InputFileDto inputFileDto, String uploadUrl);
}
