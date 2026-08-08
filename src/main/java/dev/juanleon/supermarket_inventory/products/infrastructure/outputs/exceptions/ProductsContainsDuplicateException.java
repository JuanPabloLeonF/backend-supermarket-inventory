package dev.juanleon.supermarket_inventory.products.infrastructure.outputs.exceptions;

import static dev.juanleon.supermarket_inventory.common.utils.enums.MessagesApp.PRODUCTS_CONTAINS_DUPLICATE;

public class ProductsContainsDuplicateException extends RuntimeException{

    public ProductsContainsDuplicateException(Object data) {
        super(PRODUCTS_CONTAINS_DUPLICATE.format(data));
    }
}
