package dev.juanleon.supermarket_inventory.share.exception;

import static dev.juanleon.supermarket_inventory.share.utils.enums.MessagesApp.NOT_FOUND_TYPE_REQUEST_HANDLER_MEDIATOR;

public class NotFoundTypeRequestHandlerMediator extends RuntimeException {
    public NotFoundTypeRequestHandlerMediator(String message) {
        super(NOT_FOUND_TYPE_REQUEST_HANDLER_MEDIATOR.format(message));
    }
}
