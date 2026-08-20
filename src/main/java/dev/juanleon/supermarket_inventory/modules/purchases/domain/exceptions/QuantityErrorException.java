package dev.juanleon.supermarket_inventory.modules.purchases.domain.exceptions;

import static dev.juanleon.supermarket_inventory.share.utils.enums.MessagesApp.QUANTITY_NOT_VALID;

public class QuantityErrorException extends RuntimeException {
    public QuantityErrorException(Object data) {
        super(QUANTITY_NOT_VALID.format(data));
    }
}
