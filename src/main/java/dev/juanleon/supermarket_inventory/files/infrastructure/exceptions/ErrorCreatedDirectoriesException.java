package dev.juanleon.supermarket_inventory.files.infrastructure.exceptions;

import static dev.juanleon.supermarket_inventory.common.utils.enums.MessagesApp.FAILURE_ERROR_CREATING_DIRECTORIES;

public class ErrorCreatedDirectoriesException extends RuntimeException {
    public ErrorCreatedDirectoriesException(String error) {
        super(FAILURE_ERROR_CREATING_DIRECTORIES.format(error));
    }
}
