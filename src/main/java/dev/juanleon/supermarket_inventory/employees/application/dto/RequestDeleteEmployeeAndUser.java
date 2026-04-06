package dev.juanleon.supermarket_inventory.employees.application.dto;

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
public class RequestDeleteEmployeeAndUser {
    @NotNull(message = "idEmployee is required")
    private UUID idEmployee;
    @NotNull(message = "idUser is required")
    private UUID idUser;
}
