package dev.juanleon.supermarket_inventory.modules.products.infrastructure.outputs.exceptions;

import static dev.juanleon.supermarket_inventory.share.utils.enums.MessagesApp.PRODUCTS_FOLLOWING_ARE_INACTIVES;

public class ProductsFollowingAreInactivesException extends RuntimeException{

    public ProductsFollowingAreInactivesException(Object data) {
        super(PRODUCTS_FOLLOWING_ARE_INACTIVES.format(data));
    }
}
