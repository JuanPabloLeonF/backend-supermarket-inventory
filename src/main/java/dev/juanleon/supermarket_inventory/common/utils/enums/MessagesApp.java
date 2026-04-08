package dev.juanleon.supermarket_inventory.common.utils.enums;

import lombok.Getter;

@Getter
public enum MessagesApp {

    USER_UPDATE_SUCCESSFULLY_BY_ID("User updated successfully with id: %s"),
    USER_DELETED_SUCCESSFULLY_BY_ID("User deleted successfully by id: %s"),
    USER_CREATED_SUCCESSFULLY("User created successfully with id: %s"),
    USER_NOT_FOUND_BY_ID("User not found with id: %s"),
    USER_NOT_CREATED_ON_DATABASE("User not created on database with data: %s , %s"),

    EMPLOYEE_UPDATE_SUCCESSFULLY_BY_ID("Employee updated successfully with id: %s"),
    EMPLOYEE_CREATED_SUCCESSFULLY("Employee created successfully with id: %s"),
    EMPLOYEE_DELETED_SUCCESSFULLY_BY_ID("Employee deleted successfully by id: %s"),
    EMPLOYEE_NOT_FOUND_BY_ID("Employee not found with id: %s"),
    EMPLOYEE_NOT_CREATED_ON_DATABASE("Employee not created on database with data: %s , %s"),

    FORMAT_STRING_MESSAGE("%s %s"),

    BAD_REQUEST_VALIDATED_PAGINATION_NUMBER("Page number must be greater than or equal to 0"),
    BAD_REQUEST_VALIDATED_PAGINATION_SIZE("Page size must be greater than 0");

    private final String message;

    MessagesApp(String message) {
        this.message = message;
    }

    public String format(Object... args) {
        return String.format(this.message, args);
    }
}
