package dev.juanleon.supermarket_inventory.modules.sales.domain.exceptions;

import static dev.juanleon.supermarket_inventory.share.utils.enums.MessagesApp.IVA_NOT_VALID;

public class IvaDecimalSalesException extends RuntimeException {
    public IvaDecimalSalesException(Object data) {
        super(IVA_NOT_VALID.format(data));
    }
}
