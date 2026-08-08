package dev.juanleon.supermarket_inventory.products.infrastructure.outputs.exceptions;

import static dev.juanleon.supermarket_inventory.common.utils.enums.MessagesApp.PRODUCTS_FOLLOWING_ARE_INACTIVES;

public class ProductsFollowingAreInactivesException extends RuntimeException{

    public ProductsFollowingAreInactivesException(Object data) {
        super(PRODUCTS_FOLLOWING_ARE_INACTIVES.format(data));
    }
}
