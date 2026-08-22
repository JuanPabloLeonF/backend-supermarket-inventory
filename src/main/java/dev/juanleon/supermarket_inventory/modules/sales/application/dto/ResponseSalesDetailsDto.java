package dev.juanleon.supermarket_inventory.modules.sales.application.dto;

import dev.juanleon.supermarket_inventory.modules.products.application.dto.ResponseProductDto;
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
public class ResponseSalesDetailsDto {
    private UUID id;
    private ResponseProductDto responseProductDto;
    private Integer quantity;
    private BigDecimal priceUnit;
    private BigDecimal discount;
    private BigDecimal subTotal;
    private BigDecimal iva;
    private BigDecimal total;
}
