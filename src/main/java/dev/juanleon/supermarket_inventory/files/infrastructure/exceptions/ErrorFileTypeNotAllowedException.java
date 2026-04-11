package dev.juanleon.supermarket_inventory.files.infrastructure.exceptions;

import static dev.juanleon.supermarket_inventory.common.utils.enums.MessagesApp.ERROR_FILE_TYPE_NOT_ALLOWED_EXCEPTION;

public class ErrorFileTypeNotAllowedException extends RuntimeException {
    public ErrorFileTypeNotAllowedException(String error) {
        super(ERROR_FILE_TYPE_NOT_ALLOWED_EXCEPTION.format(error));
    }
}
