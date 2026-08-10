package dev.juanleon.supermarket_inventory.share.files.exceptions;

import static dev.juanleon.supermarket_inventory.share.utils.enums.MessagesApp.FAILURE_ERROR_CREATING_DIRECTORIES;

public class ErrorCreatedDirectoriesException extends RuntimeException {
    public ErrorCreatedDirectoriesException(String error) {
        super(FAILURE_ERROR_CREATING_DIRECTORIES.format(error));
    }
}
