package dev.juanleon.supermarket_inventory.modules.purchases.domain.exceptions;

import static dev.juanleon.supermarket_inventory.share.utils.enums.MessagesApp.IVA_NOT_VALID;

public class IvaDecimalException extends RuntimeException {
    public IvaDecimalException(Object data) {
        super(IVA_NOT_VALID.format(data));
    }
}
