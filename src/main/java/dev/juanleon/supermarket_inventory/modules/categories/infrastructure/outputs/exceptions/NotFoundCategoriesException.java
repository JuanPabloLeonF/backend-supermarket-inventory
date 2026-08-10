package dev.juanleon.supermarket_inventory.modules.categories.infrastructure.outputs.exceptions;

import java.util.UUID;

import static dev.juanleon.supermarket_inventory.share.utils.enums.MessagesApp.CATEGORIES_NOT_FOUND_BY_ID;

public class NotFoundCategoriesException extends RuntimeException {
    public NotFoundCategoriesException(UUID id) {
        super(CATEGORIES_NOT_FOUND_BY_ID.format(id));
    }
}
