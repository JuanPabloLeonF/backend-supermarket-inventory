package dev.juanleon.supermarket_inventory.modules.products.application.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import dev.juanleon.supermarket_inventory.modules.categories.application.dto.ResponseCategoriesDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseProductDto {
    private UUID id;
    private ResponseCategoriesDto responseCategoriesDto;
    private String code;
    private String name;
    private String description;
    private String unitMeasurement;
    private BigDecimal priceSale;
    private BigDecimal pricePurchase;
    private Integer stock;
    private Boolean active;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdAt;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate updatedAt;
    private String urlImg;
}
