package dev.juanleon.supermarket_inventory.cash_register.application.dto;

import dev.juanleon.supermarket_inventory.employees.domain.models.EmployeeModel;
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
public class CashRegisterResponse {
    private UUID id;
    private EmployeeModel employee;
    private LocalDateTime openingTime;
    private LocalDateTime closingTime;
    private BigDecimal initialAmount;
    private BigDecimal finalAmount;
    private BigDecimal totalSales;
    private BigDecimal totalPurchases;
    private BigDecimal difference;
    private String observations;
}
