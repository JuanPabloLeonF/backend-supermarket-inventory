package dev.juanleon.supermarket_inventory.categories.infrastructure.outputs.exceptions;

import java.util.UUID;

import static dev.juanleon.supermarket_inventory.common.utils.enums.MessagesApp.CATEGORIES_NOT_FOUND_BY_ID;

public class NotFoundCategoriesException extends RuntimeException {
    public NotFoundCategoriesException(UUID id) {
        super(CATEGORIES_NOT_FOUND_BY_ID.format(id));
    }
}
