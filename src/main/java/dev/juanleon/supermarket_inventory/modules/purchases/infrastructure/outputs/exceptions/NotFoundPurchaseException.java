package dev.juanleon.supermarket_inventory.modules.purchases.infrastructure.outputs.exceptions;

import static dev.juanleon.supermarket_inventory.share.utils.enums.MessagesApp.PURCHASE_NOT_FOUND_BY_DATA;

public class NotFoundPurchaseException extends RuntimeException {
    public NotFoundPurchaseException(Object message) {
        super(PURCHASE_NOT_FOUND_BY_DATA.format(message));
    }
}
