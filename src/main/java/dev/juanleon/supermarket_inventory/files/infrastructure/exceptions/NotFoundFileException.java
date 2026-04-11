package dev.juanleon.supermarket_inventory.files.infrastructure.exceptions;

import static dev.juanleon.supermarket_inventory.common.utils.enums.MessagesApp.FILE_NOT_FOUND_BY_URL;

public class NotFoundFileException extends RuntimeException {
    public NotFoundFileException(String error) {
        super(FILE_NOT_FOUND_BY_URL.format(error));
    }
}
