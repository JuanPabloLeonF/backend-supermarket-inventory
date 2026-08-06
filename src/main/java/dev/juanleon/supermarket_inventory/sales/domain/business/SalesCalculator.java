package dev.juanleon.supermarket_inventory.sales.domain.business;

import dev.juanleon.supermarket_inventory.sales.domain.models.SalesDetailsModel;
import dev.juanleon.supermarket_inventory.sales.domain.models.SalesModel;

import java.math.BigDecimal;
import java.math.RoundingMode;


public final class SalesCalculator {

    private static final int SCALE = 2;
    private static final RoundingMode ROUNDING_MODE = RoundingMode.HALF_UP;

    private SalesCalculator(){}

    public static SalesModel calculateAllSales(SalesModel sales) {
        BigDecimal totalDiscountApply = BigDecimal.ZERO;
        BigDecimal subTotalSales = BigDecimal.ZERO;

        for (SalesDetailsModel detail : sales.getSalesDetailsModelList()) {
            BigDecimal detailTotal = calculateTotal(
                    detail.getQuantity(),
                    detail.getPriceUnit(),
                    detail.getDiscount()
            );

            detail.setTotal(detailTotal);

            subTotalSales = subTotalSales.add(detailTotal);
            totalDiscountApply = totalDiscountApply.add(detail.getDiscount());
        }

        BigDecimal ivaAmount = subTotalSales.multiply(sales.getIva()).setScale(SCALE, ROUNDING_MODE);
        BigDecimal totalSales = subTotalSales.add(ivaAmount).setScale(SCALE, ROUNDING_MODE);

        sales.setDiscount(totalDiscountApply.setScale(SCALE, ROUNDING_MODE));
        sales.setSubTotal(subTotalSales.setScale(SCALE, ROUNDING_MODE));
        sales.setTotal(totalSales);

        return sales;
    }

    public static BigDecimal calculateTotal(Integer quantity, BigDecimal priceUnit, BigDecimal discount) {
        return BigDecimal.valueOf(quantity)
                .multiply(priceUnit)
                .subtract(discount)
                .setScale(SCALE, ROUNDING_MODE);
    }
}
