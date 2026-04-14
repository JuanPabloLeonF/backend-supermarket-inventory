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
public class RequestGetByYearReport {

    @NotBlank(message = "Year is required")
    @Pattern(
            regexp = "^[0-9]+$",
            message = "El año debe contener solo números"
    )
    String year;
    PaginationRequest paginationRequest;
}
