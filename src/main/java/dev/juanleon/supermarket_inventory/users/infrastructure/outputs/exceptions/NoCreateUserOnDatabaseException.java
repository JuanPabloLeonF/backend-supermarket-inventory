package dev.juanleon.supermarket_inventory.users.infrastructure.outputs.exceptions;

import static dev.juanleon.supermarket_inventory.common.utils.enums.MessagesApp.USER_NOT_CREATED_ON_DATABASE;

public class NoCreateUserOnDatabaseException extends RuntimeException {
    public NoCreateUserOnDatabaseException(Object... args) {
        super(USER_NOT_CREATED_ON_DATABASE.format(args));
    }
}
