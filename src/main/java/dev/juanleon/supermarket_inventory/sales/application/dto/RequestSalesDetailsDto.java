package dev.juanleon.supermarket_inventory.sales.application.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
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
public class RequestSalesDetailsDto {
    @NotNull(message = "idProduct is required")
    private UUID idProduct;

    @NotNull(message = "quantity is required")
    private Integer quantity;

    @NotNull(message = "discount is required")
    @PositiveOrZero(message = "discount must be zero or positive")
    @Digits(integer = 12, fraction = 2, message = "discount has invalid format (max 12 integers and 2 decimals)")
    private BigDecimal discount;
}
