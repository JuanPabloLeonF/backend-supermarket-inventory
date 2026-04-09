package dev.juanleon.supermarket_inventory.users.infrastructure.outputs.exceptions;

import static dev.juanleon.supermarket_inventory.common.utils.enums.MessagesApp.EMAIL_ALREADY_EXISTS_USER;

public class EmailAlreadyExistsException extends RuntimeException {
    public EmailAlreadyExistsException(String message) {
        super(EMAIL_ALREADY_EXISTS_USER.format(message));
    }
}
