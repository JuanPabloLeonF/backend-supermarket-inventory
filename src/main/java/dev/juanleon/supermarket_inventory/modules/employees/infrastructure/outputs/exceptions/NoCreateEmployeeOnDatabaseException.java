package dev.juanleon.supermarket_inventory.modules.employees.infrastructure.outputs.exceptions;


import static dev.juanleon.supermarket_inventory.share.utils.enums.MessagesApp.EMPLOYEE_NOT_CREATED_ON_DATABASE;

public class NoCreateEmployeeOnDatabaseException extends RuntimeException {
    public NoCreateEmployeeOnDatabaseException(Object... args) {
        super(EMPLOYEE_NOT_CREATED_ON_DATABASE.format(args));
    }
}
