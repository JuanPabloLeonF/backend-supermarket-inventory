package dev.juanleon.supermarket_inventory.modules.reports.application.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestReportDataSales {

    @NotNull(message = "employee is required")
    private UUID employeeId;

    @NotBlank(message = "period is required")
    private String reportType;

    @NotBlank(message = "period is required")
    @Pattern(
            regexp = "^(?i)(enero|febrero|marzo|abril|mayo|junio|julio|agosto|septiembre|octubre|noviembre|diciembre)\\s\\d{4}$",
            message = "El formato debe ser 'mes año' (ej: diciembre 2024)"
    )
    private String period;

    @NotNull(message = "idModel is required")
    private UUID idModel;

    @NotBlank(message = "customerName is required")
    @Size(min = 4, max = 100, message = "customerName must be between 4 and 100 characters")
    private String customerName;

    @NotNull(message = "identificationCustomer is required")
    @Pattern(
            regexp = "^[0-9]{8,10}$",
            message = "identificationCustomer must contain between 8 and 10 digits"
    )
    private String identificationCustomer;
}
