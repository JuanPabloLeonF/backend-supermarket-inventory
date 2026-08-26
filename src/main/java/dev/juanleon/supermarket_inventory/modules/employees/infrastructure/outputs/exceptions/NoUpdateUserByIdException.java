package dev.juanleon.supermarket_inventory.modules.employees.infrastructure.outputs.exceptions;


import java.util.UUID;

import static dev.juanleon.supermarket_inventory.share.utils.enums.MessagesApp.USER_NOT_FOUND_BY_DATA;

public class NoUpdateUserByIdException extends RuntimeException{
    public NoUpdateUserByIdException(UUID id) {
        super(USER_NOT_FOUND_BY_DATA.format(id));
    }
}
