package dev.juanleon.supermarket_inventory.products.infrastructure.outputs.exceptions;

import static dev.juanleon.supermarket_inventory.common.utils.enums.MessagesApp.PRODUCTS_FOLLOWING_NOT_EXIST_;

public class ProductsFollowingNotExistException extends RuntimeException{

    public ProductsFollowingNotExistException(Object data) {
        super(PRODUCTS_FOLLOWING_NOT_EXIST_.format(data));
    }
}
