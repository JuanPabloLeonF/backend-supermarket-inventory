package dev.juanleon.supermarket_inventory.products.infrastructure.outputs.exceptions;

import static dev.juanleon.supermarket_inventory.common.utils.enums.MessagesApp.PRODUCT_NOT_FOUND_BY_ID;

public class NotFoundProductException extends RuntimeException{

    public NotFoundProductException(Object id) {
        super(PRODUCT_NOT_FOUND_BY_ID.format(id));
    }
}
