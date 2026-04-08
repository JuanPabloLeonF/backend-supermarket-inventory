package dev.juanleon.supermarket_inventory.employees.application.dto.requets;

import dev.juanleon.supermarket_inventory.common.utils.dto.PaginationRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestNameAndLastName {
    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 100, message = "NationalId must be between 2 and 100 characters")
    private String name;
    @NotBlank(message = "LastName is required")
    @Size(min = 2, max = 150, message = "NationalId must be between 2 and 150 characters")
    private String lastName;
    private PaginationRequest paginationRequest;
}
