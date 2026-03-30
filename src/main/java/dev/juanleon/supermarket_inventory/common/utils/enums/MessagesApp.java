package dev.juanleon.supermarket_inventory.common.utils.enums;

import lombok.Getter;

@Getter
public enum MessagesApp {

    USER_UPDATE_SUCCESSFULLY_BY_ID("User updated successfully with id: %s"),
    USER_DELETED_SUCCESSFULLY_BY_ID("User deleted successfully by id: %s"),
    USER_CREATED_SUCCESSFULLY("User created successfully with id: %s"),
    USER_NOT_FOUND_BY_ID("User not found with id: %s"),
    USER_NOT_CREATED_ON_DATABASE("User not created on database with data: %s , %s");

    private final String message;

    MessagesApp(String message) {
        this.message = message;
    }

    public String format(Object... args) {
        return String.format(this.message, args);
    }
}
