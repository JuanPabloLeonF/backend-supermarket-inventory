package dev.juanleon.supermarket_inventory.sales.infrastructure.outputs.exceptions;

import java.util.UUID;

import static dev.juanleon.supermarket_inventory.common.utils.enums.MessagesApp.SALES_NOT_FOUND_BY_DATA;

public class NotFoundSalesException extends RuntimeException {
    public NotFoundSalesException(UUID id) {
        super(SALES_NOT_FOUND_BY_DATA.format(id));
    }
}
