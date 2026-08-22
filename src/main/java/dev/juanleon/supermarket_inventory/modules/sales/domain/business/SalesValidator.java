package dev.juanleon.supermarket_inventory.modules.sales.domain.business;

import dev.juanleon.supermarket_inventory.modules.sales.domain.exceptions.IvaDecimalSalesException;
import dev.juanleon.supermarket_inventory.modules.sales.domain.exceptions.PriceErrorSalesException;
import dev.juanleon.supermarket_inventory.modules.sales.domain.exceptions.QuantityErrorSalesException;
import dev.juanleon.supermarket_inventory.modules.sales.domain.exceptions.currentStockErrorSalesException;

import java.math.BigDecimal;

public final class SalesValidator {

    private SalesValidator() {}

    public static void validateIva(BigDecimal iva) {
        if (iva == null || iva.compareTo(BigDecimal.ZERO) < 0 || iva.compareTo(new BigDecimal("1")) > 0) {
            throw new IvaDecimalSalesException(iva);
        }
    }

    public static void validateQuantity(Integer quantity) {
        if (quantity == null || quantity <= 0) {
            throw new QuantityErrorSalesException(quantity);
        }
    }

    public static void validatePrice(BigDecimal price) {
        if (price == null || price.compareTo(BigDecimal.ZERO) <= 0) {
            throw new PriceErrorSalesException(price);
        }
    }

    public static void validateCurrentStock(Integer stock) {
        if (stock == null || stock <= 0) {
            throw new currentStockErrorSalesException(stock);
        }
    }
}
