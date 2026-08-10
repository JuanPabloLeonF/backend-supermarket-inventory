package dev.juanleon.supermarket_inventory.modules.products.domain.ports;

import dev.juanleon.supermarket_inventory.share.utils.dto.InputFileDto;

public interface IFilesProviderProduct {
    String createImage(InputFileDto inputFileDto, String uploadUrl);
}
