package dev.juanleon.supermarket_inventory.users.infrastructure.outputs.exceptions;

public class NotFoundUserException extends RuntimeException {
    public NotFoundUserException(String message) {
        super(message);
    }
}
