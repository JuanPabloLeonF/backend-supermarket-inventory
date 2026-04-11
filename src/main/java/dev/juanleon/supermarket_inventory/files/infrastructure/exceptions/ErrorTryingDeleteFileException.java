package dev.juanleon.supermarket_inventory.files.infrastructure.exceptions;

import static dev.juanleon.supermarket_inventory.common.utils.enums.MessagesApp.FILE_ERROR_TRYING_DELETE;

public class ErrorTryingDeleteFileException extends RuntimeException {
    public ErrorTryingDeleteFileException(String error) {
        super(FILE_ERROR_TRYING_DELETE.format(error));
    }
}
