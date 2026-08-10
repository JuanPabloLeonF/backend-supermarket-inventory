package dev.juanleon.supermarket_inventory.modules.products.application.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestProductUpdateUrlImgDto {

    @NotNull(message = "Product id is required")
    private UUID productId;

    @NotNull(message = "Image is required")
    private MultipartFile imgFile;
}
