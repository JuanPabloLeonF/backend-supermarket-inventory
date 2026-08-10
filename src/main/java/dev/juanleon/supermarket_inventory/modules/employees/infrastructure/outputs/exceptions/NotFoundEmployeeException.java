package dev.juanleon.supermarket_inventory.modules.employees.infrastructure.outputs.exceptions;

import java.util.UUID;

import static dev.juanleon.supermarket_inventory.share.utils.enums.MessagesApp.EMPLOYEE_NOT_FOUND_BY_ID;

public class NotFoundEmployeeException extends RuntimeException {
    public NotFoundEmployeeException(UUID id) {
        super(EMPLOYEE_NOT_FOUND_BY_ID.format(id));
    }
}
