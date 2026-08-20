package dev.juanleon.supermarket_inventory.modules.purchases.domain.exceptions;

import static dev.juanleon.supermarket_inventory.share.utils.enums.MessagesApp.PRICE_NOT_VALID;

public class PriceErrorException extends RuntimeException {
    public PriceErrorException(Object data) {
        super(PRICE_NOT_VALID.format(data));
    }
}
