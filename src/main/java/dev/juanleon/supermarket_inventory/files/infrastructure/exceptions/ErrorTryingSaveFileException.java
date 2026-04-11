package dev.juanleon.supermarket_inventory.files.infrastructure.exceptions;

import static dev.juanleon.supermarket_inventory.common.utils.enums.MessagesApp.FILE_ERROR_TRYING_SAVE;

public class ErrorTryingSaveFileException extends RuntimeException {
    public ErrorTryingSaveFileException(String error) {
        super(FILE_ERROR_TRYING_SAVE.format(error));
    }
}
