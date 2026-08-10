package dev.juanleon.supermarket_inventory.modules.employees.infrastructure.outputs.exceptions;

import static dev.juanleon.supermarket_inventory.share.utils.enums.MessagesApp.USER_NOT_CREATED_ON_DATABASE;

public class NoCreateUserOnDatabaseException extends RuntimeException {
    public NoCreateUserOnDatabaseException(Object... args) {
        super(USER_NOT_CREATED_ON_DATABASE.format(args));
    }
}
