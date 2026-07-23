package dev.juanleon.supermarket_inventory.products.application.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import dev.juanleon.supermarket_inventory.categories.application.dto.ResponseCategoriesDto;
import dev.juanleon.supermarket_inventory.categories.domain.models.CategoriesModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private Double priceSale;
    private Double pricePurchase;
    private Integer stock;
    private Boolean active;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdAt;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate updatedAt;
}
