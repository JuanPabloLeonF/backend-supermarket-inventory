package dev.juanleon.supermarket_inventory.sales.application.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SalesRequestDTO {

    @NotNull(message = "employeeId is required")
    private UUID employeeId;

    @NotNull(message = "numberSale is required")
    private UUID numberSale;

    @NotNull(message = "dateSale is required")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateSale;

    @NotNull(message = "subTotal is required")
    @PositiveOrZero(message = "subTotal must be zero or positive")
    @Digits(integer = 12, fraction = 2, message = "subTotal has invalid format (max 12 integers and 2 decimals)")
    private BigDecimal subTotal;

    @NotNull(message = "discount is required")
    @PositiveOrZero(message = "discount must be zero or positive")
    @Digits(integer = 12, fraction = 2, message = "discount has invalid format (max 12 integers and 2 decimals)")
    private BigDecimal discount;

    @NotNull(message = "iva is required")
    @PositiveOrZero(message = "iva must be zero or positive")
    @Digits(integer = 12, fraction = 2, message = "iva has invalid format (max 12 integers and 2 decimals)")
    private BigDecimal iva;

    @NotNull(message = "total is required")
    @PositiveOrZero(message = "total must be zero or positive")
    @Digits(integer = 12, fraction = 2, message = "total has invalid format (max 12 integers and 2 decimals)")
    private BigDecimal total;

    @NotBlank(message = "methodPayment is required")
    @Size(min = 5, max = 500, message = "methodPayment must be between 5 and 500 characters")
    private String methodPayment;

    @NotBlank(message = "status is required")
    @Size(min = 5, max = 300, message = "status must be between 5 and 500 characters")
    private String status;
}
