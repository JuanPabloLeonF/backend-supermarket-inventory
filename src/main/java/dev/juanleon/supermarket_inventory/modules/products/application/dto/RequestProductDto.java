package dev.juanleon.supermarket_inventory.modules.products.application.dto;

import dev.juanleon.supermarket_inventory.share.utils.enums.UnitMeasurement;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestProductDto {
    @NotNull(message = "idCategories data is required")
    private UUID idCategories;

    @NotBlank(message = "code is required")
    @Size(min = 12, max = 12, message = "code must be 12 characters")
    private String code;

    @NotBlank(message = "name is required")
    @Size(min = 2, max = 250, message = "name must be between 2 and 250 characters")
    private String name;

    @NotBlank(message = "description is required")
    @Size(min = 2, max = 250, message = "description must be between 2 and 250 characters")
    private String description;

    @NotNull(message = "Unit measurement is required")
    private UnitMeasurement unitMeasurement;

    @NotNull(message = "Price sale is required")
    @Positive(message = "Price sale must be greater than 0")
    @Digits(integer = 12, fraction = 2, message = "priceSale has invalid format (max 12 integers and 2 decimals)")
    private BigDecimal priceSale;

    @NotNull(message = "Price purchase is required")
    @Positive(message = "Price purchase must be greater than 0")
    @Digits(integer = 12, fraction = 2, message = "pricePurchase has invalid format (max 12 integers and 2 decimals)")
    private BigDecimal pricePurchase;

    @NotNull(message = "Stock is required")
    @PositiveOrZero(message = "Stock cannot be negative")
    private Integer stock;

    @NotNull(message = "Active is required")
    private Boolean active;

    @NotNull(message = "Image is required")
    private MultipartFile imgFile;
}
