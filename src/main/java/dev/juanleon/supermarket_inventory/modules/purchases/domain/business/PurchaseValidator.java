package dev.juanleon.supermarket_inventory.modules.purchases.domain.business;

import dev.juanleon.supermarket_inventory.modules.purchases.domain.exceptions.IvaDecimalException;
import dev.juanleon.supermarket_inventory.modules.purchases.domain.exceptions.PriceErrorException;
import dev.juanleon.supermarket_inventory.modules.purchases.domain.exceptions.QuantityErrorException;

import java.math.BigDecimal;

public final class PurchaseValidator {

    private PurchaseValidator() {}

    public static void validateIva(BigDecimal iva) {
        if (iva == null || iva.compareTo(BigDecimal.ZERO) < 0 || iva.compareTo(new BigDecimal("1")) > 0) {
            throw new IvaDecimalException(iva);
        }
    }

    public static void validateQuantity(Integer quantity) {
        if (quantity == null || quantity <= 0) {
            throw new QuantityErrorException(quantity);
        }
    }

    public static void validatePrice(BigDecimal price) {
        if (price == null || price.compareTo(BigDecimal.ZERO) <= 0) {
            throw new PriceErrorException(price);
        }
    }
}
