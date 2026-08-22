package dev.juanleon.supermarket_inventory.modules.sales.domain.exceptions;

import static dev.juanleon.supermarket_inventory.share.utils.enums.MessagesApp.QUANTITY_NOT_VALID;

public class QuantityErrorSalesException extends RuntimeException {
    public QuantityErrorSalesException(Object data) {
        super(QUANTITY_NOT_VALID.format(data));
    }
}
