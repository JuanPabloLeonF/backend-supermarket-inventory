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
        Map<UUID, Integer> newStockMap = new HashMap<>();

        for (PurchaseDetailsModel detail : purchase.getPurchaseDetailModelList()) {

            Integer newStock = decrementProductStock(
                    detail.getQuantity(),
                    detail.getProductModel().getStock()
            );

            newStockMap.put(detail.getProductModel().getId(), newStock);

            BigDecimal detailTotal = calculateTotal(
                    detail.getQuantity(),
                    detail.getProductModel().getPricePurchase(),
                    detail.getDiscount()
            );

            detail.setTotal(detailTotal);

            subTotalPurchases = subTotalPurchases.add(detailTotal);
            totalDiscountApply = totalDiscountApply.add(detail.getDiscount());
        }

        BigDecimal ivaAmount = subTotalPurchases.multiply(purchase.getIva()).setScale(SCALE, ROUNDING_MODE);
        BigDecimal totalPurchases = subTotalPurchases.add(ivaAmount).setScale(SCALE, ROUNDING_MODE);

        purchase.setDiscount(totalDiscountApply.setScale(SCALE, ROUNDING_MODE));
        purchase.setSubTotal(subTotalPurchases.setScale(SCALE, ROUNDING_MODE));
        purchase.setTotal(totalPurchases);

        return new PostDataBusinessPurchase(purchase, newStockMap);
    }

    public static BigDecimal calculateTotal(Integer quantity, BigDecimal priceUnit, BigDecimal discount) {
        return BigDecimal.valueOf(quantity)
                .multiply(priceUnit)
                .subtract(discount)
                .setScale(SCALE, ROUNDING_MODE);
    }

    private static Integer decrementProductStock(Integer quantity, Integer currentStock) {

        int newStock = currentStock - quantity;

        if (newStock < 0) {
            throw new IllegalArgumentException("Insufficient stock for product: " + currentStock);
        }

        return newStock;
    }
}
