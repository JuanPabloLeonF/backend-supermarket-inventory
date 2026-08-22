package dev.juanleon.supermarket_inventory.modules.sales.domain.exceptions;

import static dev.juanleon.supermarket_inventory.share.utils.enums.MessagesApp.STOCK_NOT_VALID;

public class currentStockErrorSalesException extends RuntimeException {
    public currentStockErrorSalesException(Object data) {
        super(STOCK_NOT_VALID.format(data));
    }
}
