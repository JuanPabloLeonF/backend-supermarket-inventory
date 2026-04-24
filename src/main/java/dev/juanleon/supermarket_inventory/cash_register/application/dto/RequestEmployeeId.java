package dev.juanleon.supermarket_inventory.cash_register.application.dto;

import dev.juanleon.supermarket_inventory.common.utils.dto.PaginationRequest;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestEmployeeId {
    @NotNull(message = "employeeId is required")
    private UUID employeeId;
    private PaginationRequest paginationRequest;
}
