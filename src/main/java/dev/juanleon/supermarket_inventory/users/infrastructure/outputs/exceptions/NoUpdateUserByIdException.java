package dev.juanleon.supermarket_inventory.users.infrastructure.outputs.exceptions;


import java.util.UUID;

import static dev.juanleon.supermarket_inventory.common.utils.enums.MessagesApp.USER_NOT_FOUND_BY_ID;

public class NoUpdateUserByIdException extends RuntimeException{
    public NoUpdateUserByIdException(UUID id) {
        super(USER_NOT_FOUND_BY_ID.format(id));
    }
}
