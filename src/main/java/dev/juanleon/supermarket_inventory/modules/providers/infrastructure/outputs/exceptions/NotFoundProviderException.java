package dev.juanleon.supermarket_inventory.modules.providers.infrastructure.outputs.exceptions;

import static dev.juanleon.supermarket_inventory.share.utils.enums.MessagesApp.PROVIDER_NOT_FOUND_BY_DATA;

public class NotFoundProviderException extends RuntimeException {
    public NotFoundProviderException(Object data) {
        super(PROVIDER_NOT_FOUND_BY_DATA.format(data));
    }
}
