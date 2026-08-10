package dev.juanleon.supermarket_inventory.modules.products.application.dto;

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
public class RequestProductUpdateActivateDto {

    @NotNull(message = "productId data is required")
    private UUID productId;

    @NotNull(message = "active data is required")
    private Boolean active;
}
