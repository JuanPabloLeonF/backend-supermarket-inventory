package dev.juanleon.supermarket_inventory.users.infrastructure.outputs.exceptions;

public class NoCreateUserOnDatabaseException extends RuntimeException {
    public NoCreateUserOnDatabaseException(String message) {
        super(message);
    }
}
