package dev.juanleon.supermarket_inventory.modules.providers.application.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class ResponseProviderDto {
    private UUID id;
    private String fullName;
    private String identification;
    private String email;
    private String cellPhone;
    private String direction;
    private String city;
    private Boolean activate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdAt;
}
