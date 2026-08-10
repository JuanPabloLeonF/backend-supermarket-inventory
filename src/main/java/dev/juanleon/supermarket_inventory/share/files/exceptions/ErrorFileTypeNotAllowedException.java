package dev.juanleon.supermarket_inventory.share.files.exceptions;

import static dev.juanleon.supermarket_inventory.share.utils.enums.MessagesApp.ERROR_FILE_TYPE_NOT_ALLOWED_EXCEPTION;

public class ErrorFileTypeNotAllowedException extends RuntimeException {
    public ErrorFileTypeNotAllowedException(String error) {
        super(ERROR_FILE_TYPE_NOT_ALLOWED_EXCEPTION.format(error));
    }
}
