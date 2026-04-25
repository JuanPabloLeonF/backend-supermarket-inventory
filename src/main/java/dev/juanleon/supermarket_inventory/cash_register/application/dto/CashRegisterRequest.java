package dev.juanleon.supermarket_inventory.cash_register.application.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import dev.juanleon.supermarket_inventory.employees.domain.models.EmployeeModel;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CashRegisterRequest {

    @Valid
    @NotNull(message = "employee data is required")
    private EmployeeModel employee;

    @NotNull(message = "openingTime date is required")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime openingTime;

    @NotNull(message = "closingTime date is required")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime closingTime;

    @NotNull(message = "initialAmount is required")
    @PositiveOrZero(message = "initialAmount must be zero or positive")
    @Digits(integer = 12, fraction = 2, message = "initialAmount has invalid format (max 12 integers and 2 decimals)")
    private BigDecimal initialAmount;

    @PositiveOrZero(message = "finalAmount must be zero or positive")
    @Digits(integer = 12, fraction = 2)
    private BigDecimal finalAmount;

    @PositiveOrZero(message = "totalSales must be zero or positive")
    @Digits(integer = 12, fraction = 2)
    private BigDecimal totalSales;

    @PositiveOrZero(message = "totalPurchases must be zero or positive")
    @Digits(integer = 12, fraction = 2)
    private BigDecimal totalPurchases;

    @Digits(integer = 12, fraction = 2)
    private BigDecimal difference;

    @NotBlank(message = "observations is required")
    @Size(min = 5, max = 500, message = "observations must be between 5 and 500 characters")
    private String observations;
}
