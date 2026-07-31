package dev.juanleon.supermarket_inventory.products.application.dto;

import dev.juanleon.supermarket_inventory.common.utils.dto.InputFileDto;
import dev.juanleon.supermarket_inventory.common.utils.enums.UnitMeasurement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestProductFileDto {
    private UUID idCategories;
    private String code;
    private String name;
    private String description;
    private UnitMeasurement unitMeasurement;
    private BigDecimal priceSale;
    private BigDecimal pricePurchase;
    private Integer stock;
    private Boolean active;
    private InputFileDto inputFileDto;
}
