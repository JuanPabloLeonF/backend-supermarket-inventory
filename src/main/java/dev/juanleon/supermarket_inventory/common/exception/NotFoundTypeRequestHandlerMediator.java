package dev.juanleon.supermarket_inventory.common.exception;

public class NotFoundTypeRequestHandlerMediator extends RuntimeException {
    public NotFoundTypeRequestHandlerMediator(String message) {
        super(message);
    }
}
