package dev.juanleon.supermarket_inventory.employees.application.dto.requets;

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
public class RequestUpdateImage {

    @NotNull(message = "id is required")
    private UUID id;

    @NotNull(message = "fileImg is required")
    private MultipartFile fileImg;
}
