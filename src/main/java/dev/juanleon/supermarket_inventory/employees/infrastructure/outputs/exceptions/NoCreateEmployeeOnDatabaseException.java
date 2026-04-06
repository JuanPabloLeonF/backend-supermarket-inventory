package dev.juanleon.supermarket_inventory.employees.infrastructure.outputs.exceptions;


import static dev.juanleon.supermarket_inventory.common.utils.enums.MessagesApp.EMPLOYEE_NOT_CREATED_ON_DATABASE;

public class NoCreateEmployeeOnDatabaseException extends RuntimeException {
    public NoCreateEmployeeOnDatabaseException(Object... args) {
        super(EMPLOYEE_NOT_CREATED_ON_DATABASE.format(args));
    }
}
