package dev.juanleon.supermarket_inventory.reports.application.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestReportSalesData {

    @NotBlank(message = "customerName is required")
    @Size(min = 4, max = 100, message = "customerName must be between 4 and 100 characters")
    private String customerName;

    @NotNull(message = "customerId is required")
    private String customerId;

    @NotBlank(message = "employeeName is required")
    @Size(min = 4, max = 100, message = "employeeName must be between 4 and 100 characters")
    private String employeeName;

    @NotBlank(message = "paymentType is required")
    @Size(min = 5, max = 100, message = "paymentType must be between 4 and 100 characters")
    private String paymentType;

    @Valid
    @NotNull(message = "items is required")
    private List<RequestReportSalesItemDto> items;

    @NotNull(message = "subtotal is required")
    private BigDecimal subtotal;

    @NotNull(message = "taxAmount is required")
    private BigDecimal taxAmount;

    @NotNull(message = "total is required")
    private BigDecimal total;
}
