package dev.juanleon.supermarket_inventory.modules.products.infrastructure.outputs.exceptions;

import static dev.juanleon.supermarket_inventory.share.utils.enums.MessagesApp.PRODUCTS_CONTAINS_DUPLICATE;

public class ProductsContainsDuplicateException extends RuntimeException{

    public ProductsContainsDuplicateException(Object data) {
        super(PRODUCTS_CONTAINS_DUPLICATE.format(data));
    }
}
