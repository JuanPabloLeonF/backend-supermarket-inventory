package dev.juanleon.supermarket_inventory.reports.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestReportDto {

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
}
