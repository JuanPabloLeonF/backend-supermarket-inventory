package dev.juanleon.supermarket_inventory.modules.employees.infrastructure.outputs.exceptions;

import static dev.juanleon.supermarket_inventory.share.utils.enums.MessagesApp.USER_NOT_FOUND_BY_DATA;

public class NotFoundUserException extends RuntimeException {
    public NotFoundUserException(Object data) {
        super(USER_NOT_FOUND_BY_DATA.format(data));
    }
}
