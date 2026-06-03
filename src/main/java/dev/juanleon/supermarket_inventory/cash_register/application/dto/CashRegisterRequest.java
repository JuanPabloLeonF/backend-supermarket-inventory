package dev.juanleon.supermarket_inventory.cash_register.application.dto;

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
public class CashRegisterRequest {

    @NotNull(message = "employeeId is required")
    private UUID employeeId;

    @NotNull(message = "openingTime date is required")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime openingTime;

    @NotNull(message = "closingTime date is required")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime closingTime;

    @NotNull(message = "initialAmount is required")
    @PositiveOrZero(message = "initialAmount must be zero or positive")
    @Digits(integer = 12, fraction = 2, message = "initialAmount has invalid format (max 12 integers and 2 decimals)")
    private BigDecimal initialAmount;

    @NotNull(message = "finalAmount is required")
    @PositiveOrZero(message = "finalAmount must be zero or positive")
    @Digits(integer = 12, fraction = 2)
    private BigDecimal finalAmount;

    @NotNull(message = "totalSales is required")
    @PositiveOrZero(message = "totalSales must be zero or positive")
    @Digits(integer = 12, fraction = 2)
    private BigDecimal totalSales;

    @NotNull(message = "totalSales is required")
    @PositiveOrZero(message = "totalPurchases must be zero or positive")
    @Digits(integer = 12, fraction = 2)
    private BigDecimal totalPurchases;

    @NotNull(message = "difference is required")
    @Digits(integer = 12, fraction = 2)
    private BigDecimal difference;

    @NotBlank(message = "observations is required")
    @Size(min = 5, max = 500, message = "observations must be between 5 and 500 characters")
    private String observations;
}
