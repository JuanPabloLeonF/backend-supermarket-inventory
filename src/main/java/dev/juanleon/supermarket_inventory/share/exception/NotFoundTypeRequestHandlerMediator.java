package dev.juanleon.supermarket_inventory.share.exception;

public class NotFoundTypeRequestHandlerMediator extends RuntimeException {
    public NotFoundTypeRequestHandlerMediator(String message) {
        super(message);
    }
}
