package dev.juanleon.supermarket_inventory.cash_register.infrastructure.outputs.exceptions;

import java.util.UUID;

import static dev.juanleon.supermarket_inventory.common.utils.enums.MessagesApp.CASH_REGISTER_NOT_FOUND_BY_ID;

public class NotFoundCashRegisterException extends RuntimeException {
    public NotFoundCashRegisterException(UUID id) {
        super(CASH_REGISTER_NOT_FOUND_BY_ID.format(id));
    }
}
