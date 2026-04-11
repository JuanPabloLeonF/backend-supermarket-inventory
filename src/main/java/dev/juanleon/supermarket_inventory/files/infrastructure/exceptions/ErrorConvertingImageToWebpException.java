package dev.juanleon.supermarket_inventory.files.infrastructure.exceptions;

import static dev.juanleon.supermarket_inventory.common.utils.enums.MessagesApp.FILE_ERROR_CONVERT_IMAGE_TO_WEBP;

public class ErrorConvertingImageToWebpException extends RuntimeException {
    public ErrorConvertingImageToWebpException(String error) {
        super(FILE_ERROR_CONVERT_IMAGE_TO_WEBP.format(error));
    }
}
