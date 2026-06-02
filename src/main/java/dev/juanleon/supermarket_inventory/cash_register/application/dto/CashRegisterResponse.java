package dev.juanleon.supermarket_inventory.cash_register.application.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import dev.juanleon.supermarket_inventory.employees.application.dto.responses.ResponseEmployeeDto;
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
    private ResponseEmployeeDto employee;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime openingTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime closingTime;
    private BigDecimal initialAmount;
    private BigDecimal finalAmount;
    private BigDecimal totalSales;
    private BigDecimal totalPurchases;
    private BigDecimal difference;
    private String observations;
}
