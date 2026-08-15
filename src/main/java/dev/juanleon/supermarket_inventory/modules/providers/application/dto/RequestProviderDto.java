package dev.juanleon.supermarket_inventory.modules.providers.application.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestProviderDto {

    @NotBlank(message = "fullName is required")
    private String fullName;

    @NotBlank(message = "identification is required")
    private String identification;

    @NotBlank(message = "email is required")
    @Email(message = "email must be a valid email address")
    private String email;

    @NotBlank(message = "cellPhone is required")
    @Pattern(regexp = "^\\+\\d{1,3}\\s\\d{10}$", message = "cellPhone must match format '+xx xxxxxxxxxx'")
    private String cellPhone;

    @NotBlank(message = "direction is required")
    @Size(min = 2, max = 255, message = "direction must be between 2 and 255 characters")
    private String direction;

    @NotBlank(message = "city is required")
    private String city;

    @NotNull(message = "activate is required")
    private Boolean activate;
}
