package dev.juanleon.supermarket_inventory.modules.sales.domain.business;

import dev.juanleon.supermarket_inventory.modules.sales.domain.models.PostDataBusinessSales;
import dev.juanleon.supermarket_inventory.modules.sales.domain.models.SalesDetailsModel;
import dev.juanleon.supermarket_inventory.modules.sales.domain.models.SalesModel;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


public final class SalesCalculator {

    private static final int SCALE = 2;
    private static final RoundingMode ROUNDING_MODE = RoundingMode.HALF_UP;

    private SalesCalculator(){}

    public static PostDataBusinessSales calculateAllSales(SalesModel sales) {
        BigDecimal totalDiscountApply = BigDecimal.ZERO;
        BigDecimal subTotalPurchases = BigDecimal.ZERO;
        BigDecimal ivaTotalApply = BigDecimal.ZERO;
        BigDecimal totalPurchases = BigDecimal.ZERO;
        Map<UUID, Integer> newStockMap = new HashMap<>();

        for (SalesDetailsModel detail : sales.getSalesDetailsModelList()) {

            SalesValidator.validateIva(detail.getIva());
            SalesValidator.validateQuantity(detail.getQuantity());
            SalesValidator.validatePrice(detail.getProductModel().getPricePurchase());

            Integer newStock = decrementProductStock(detail.getQuantity(), detail.getProductModel().getStock());

            BigDecimal detailSubTotal = calculateSubTotal(detail.getQuantity(), detail.getProductModel().getPricePurchase());

            BigDecimal subTotalWithDiscount = calculatedDiscount(detail.getDiscount(), detailSubTotal);

            BigDecimal ivaAmount = calculateIvaAmount(subTotalWithDiscount, detail.getIva());

            BigDecimal detailTotal = calculateTotal(subTotalWithDiscount, ivaAmount);

            newStockMap.put(detail.getProductModel().getId(), newStock);
            detail.setSubTotal(detailSubTotal);
            detail.setTotal(detailTotal);

            ivaTotalApply = ivaTotalApply.add(ivaAmount);
            subTotalPurchases = subTotalPurchases.add(detail.getSubTotal());
            totalDiscountApply = totalDiscountApply.add(detail.getDiscount());
            totalPurchases = totalPurchases.add(detail.getTotal());
        }

        sales.setDiscount(totalDiscountApply.setScale(SCALE, ROUNDING_MODE));
        sales.setSubTotal(subTotalPurchases.setScale(SCALE, ROUNDING_MODE));
        sales.setIva(ivaTotalApply.setScale(SCALE, ROUNDING_MODE));
        sales.setTotal(totalPurchases.setScale(SCALE, ROUNDING_MODE));

        return new PostDataBusinessSales(sales, newStockMap);
    }

    public static BigDecimal calculatedDiscount(BigDecimal discount, BigDecimal subTotal) {
        BigDecimal subTotalWithDiscount = subTotal.subtract(discount);
        if (subTotalWithDiscount.compareTo(BigDecimal.ZERO) < 0) {
            subTotalWithDiscount = BigDecimal.ZERO;
        }
        return subTotalWithDiscount;
    }

    public static BigDecimal calculateIvaAmount(BigDecimal subTotalWithDiscount, BigDecimal ivaAmount) {
        return subTotalWithDiscount.multiply(ivaAmount).setScale(SCALE, ROUNDING_MODE);
    }

    public static BigDecimal calculateTotal(BigDecimal subTotalWithDiscount, BigDecimal ivaAmount) {
        return subTotalWithDiscount.add(ivaAmount).setScale(SCALE, ROUNDING_MODE);
    }

    public static BigDecimal calculateSubTotal(Integer quantity, BigDecimal priceUnit) {
        return BigDecimal.valueOf(quantity).multiply(priceUnit).setScale(SCALE, ROUNDING_MODE);
    }

    private static Integer decrementProductStock(Integer quantity, Integer currentStock) {
        int newStock = currentStock - quantity;

        SalesValidator.validateCurrentStock(newStock);

        return newStock;
    }
}
