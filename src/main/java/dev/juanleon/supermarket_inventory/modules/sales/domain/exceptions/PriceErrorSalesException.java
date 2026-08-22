package dev.juanleon.supermarket_inventory.modules.sales.domain.exceptions;

import static dev.juanleon.supermarket_inventory.share.utils.enums.MessagesApp.PRICE_NOT_VALID;

public class PriceErrorSalesException extends RuntimeException {
    public PriceErrorSalesException(Object data) {
        super(PRICE_NOT_VALID.format(data));
    }
}
