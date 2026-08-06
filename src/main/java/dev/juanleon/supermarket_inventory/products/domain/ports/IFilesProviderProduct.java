package dev.juanleon.supermarket_inventory.products.domain.ports;

import dev.juanleon.supermarket_inventory.common.utils.dto.InputFileDto;

public interface IFilesProviderProduct {
    String createImage(InputFileDto inputFileDto, String uploadUrl);
}
