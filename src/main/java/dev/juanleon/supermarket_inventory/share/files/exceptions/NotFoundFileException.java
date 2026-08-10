package dev.juanleon.supermarket_inventory.share.files.exceptions;

import static dev.juanleon.supermarket_inventory.share.utils.enums.MessagesApp.FILE_NOT_FOUND_BY_URL;

public class NotFoundFileException extends RuntimeException {
    public NotFoundFileException(String error) {
        super(FILE_NOT_FOUND_BY_URL.format(error));
    }
}
