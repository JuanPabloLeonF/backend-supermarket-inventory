package dev.juanleon.supermarket_inventory.modules.sales.application.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestSalesDto {

    @NotNull(message = "employeeId is required")
    private UUID employeeId;

    @NotBlank(message = "methodPayment is required")
    @Size(min = 5, max = 500, message = "methodPayment must be between 5 and 500 characters")
    private String methodPayment;

    @Valid
    @NotNull(message = "requestSalesDetailsDto is required")
    private List<RequestSalesDetailsDto> requestSalesDetailsDtoList;
}
