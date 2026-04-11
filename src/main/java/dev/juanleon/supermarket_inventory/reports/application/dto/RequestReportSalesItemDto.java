package dev.juanleon.supermarket_inventory.reports.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestReportSalesItemDto {
    @NotBlank(message = "name is required")
    @Size(min = 4, max = 100, message = "name must be between 4 and 100 characters")
    private String name;
    @NotNull(message = "quantity is required")
    private Integer quantity;
    @NotNull(message = "unitPrice is required")
    private BigDecimal unitPrice;
}
