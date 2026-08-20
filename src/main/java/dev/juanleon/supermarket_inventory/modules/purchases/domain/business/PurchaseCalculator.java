package dev.juanleon.supermarket_inventory.modules.purchases.domain.business;

import dev.juanleon.supermarket_inventory.modules.purchases.domain.models.PostDataBusinessPurchase;
import dev.juanleon.supermarket_inventory.modules.purchases.domain.models.PurchaseDetailsModel;
import dev.juanleon.supermarket_inventory.modules.purchases.domain.models.PurchaseModel;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class PurchaseCalculator {

    private static final int SCALE = 2;
    private static final RoundingMode ROUNDING_MODE = RoundingMode.HALF_UP;

    private PurchaseCalculator(){}

    public static PostDataBusinessPurchase calculateAllPurchases(PurchaseModel purchase) {

        BigDecimal totalDiscountApply = BigDecimal.ZERO;
        BigDecimal subTotalPurchases = BigDecimal.ZERO;
        BigDecimal ivaTotalApply = BigDecimal.ZERO;
        BigDecimal totalPurchases = BigDecimal.ZERO;
        Map<UUID, Integer> newStockMap = new HashMap<>();

        for (PurchaseDetailsModel detail : purchase.getPurchaseDetailModelList()) {

            PurchaseValidator.validateIva(detail.getIva());
            PurchaseValidator.validateQuantity(detail.getQuantity());
            PurchaseValidator.validatePrice(detail.getProductModel().getPricePurchase());

            Integer newStock = incrementProductStock(detail.getQuantity(), detail.getProductModel().getStock());

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

        purchase.setDiscount(totalDiscountApply.setScale(SCALE, ROUNDING_MODE));
        purchase.setSubTotal(subTotalPurchases.setScale(SCALE, ROUNDING_MODE));
        purchase.setIva(ivaTotalApply.setScale(SCALE, ROUNDING_MODE));
        purchase.setTotal(totalPurchases.setScale(SCALE, ROUNDING_MODE));

        return new PostDataBusinessPurchase(purchase, newStockMap);
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

    private static Integer incrementProductStock(Integer quantity, Integer currentStock) {
        return currentStock + quantity;
    }
}
