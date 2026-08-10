package dev.juanleon.supermarket_inventory.modules.products.infrastructure.outputs.exceptions;

import static dev.juanleon.supermarket_inventory.share.utils.enums.MessagesApp.PRODUCT_NOT_FOUND_BY_DATA;

public class NotFoundProductException extends RuntimeException{

    public NotFoundProductException(Object data) {
        super(PRODUCT_NOT_FOUND_BY_DATA.format(data));
    }
}
