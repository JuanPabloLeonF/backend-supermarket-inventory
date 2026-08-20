package dev.juanleon.supermarket_inventory.modules.purchases.application.dto;

import dev.juanleon.supermarket_inventory.modules.products.domain.models.ProductModel;
import dev.juanleon.supermarket_inventory.modules.purchases.domain.models.PurchaseModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponsePurchaseDetailDto {
    private UUID id;
    private PurchaseModel purchaseModel;
    private ProductModel productModel;
    private Integer quantity;
    private BigDecimal priceUnit;
    private BigDecimal subTotal;
    private BigDecimal iva;
    private BigDecimal discount;
    private BigDecimal total;
}
