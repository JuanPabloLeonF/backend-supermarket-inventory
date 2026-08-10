package dev.juanleon.supermarket_inventory.share.files.exceptions;

import static dev.juanleon.supermarket_inventory.share.utils.enums.MessagesApp.FILE_ERROR_CONVERT_IMAGE_TO_WEBP;

public class ErrorConvertingImageToWebpException extends RuntimeException {
    public ErrorConvertingImageToWebpException(String error) {
        super(FILE_ERROR_CONVERT_IMAGE_TO_WEBP.format(error));
    }
}
