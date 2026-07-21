package dev.juanleon.supermarket_inventory.categories.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseCategoriesDto {
    private UUID id;
    private String name;
    private String description;
}
