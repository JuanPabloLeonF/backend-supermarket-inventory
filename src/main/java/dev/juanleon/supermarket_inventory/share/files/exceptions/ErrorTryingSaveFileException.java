package dev.juanleon.supermarket_inventory.share.files.exceptions;

import static dev.juanleon.supermarket_inventory.share.utils.enums.MessagesApp.FILE_ERROR_TRYING_SAVE;

public class ErrorTryingSaveFileException extends RuntimeException {
    public ErrorTryingSaveFileException(String error) {
        super(FILE_ERROR_TRYING_SAVE.format(error));
    }
}
