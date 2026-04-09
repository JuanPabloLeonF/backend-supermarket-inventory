package dev.juanleon.supermarket_inventory.reports.application.dto;

import dev.juanleon.supermarket_inventory.common.utils.dto.PaginationRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestGetByPeriodReport {

    @NotBlank(message = "Period is required")
    @Pattern(
            regexp = "^(enero|febrero|marzo|abril|mayo|junio|julio|agosto|septiembre|octubre|noviembre|diciembre)\\s\\d{4}$",
            message = "El periodo debe tener el formato 'mes año' (ejemplo: 'diciembre 2026') y ser en minúsculas"
    )
    String period;
    PaginationRequest paginationRequest;
}
