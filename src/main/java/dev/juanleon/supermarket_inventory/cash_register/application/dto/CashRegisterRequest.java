package dev.juanleon.supermarket_inventory.cash_register.application.dto;

import dev.juanleon.supermarket_inventory.employees.domain.models.EmployeeModel;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CashRegisterRequest {
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
