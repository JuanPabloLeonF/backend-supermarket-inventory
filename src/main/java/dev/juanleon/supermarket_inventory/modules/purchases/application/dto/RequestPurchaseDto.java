package dev.juanleon.supermarket_inventory.modules.purchases.application.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestPurchaseDto {

    @NotNull(message = "employeeId is required")
    private UUID employeeId;

    @NotNull(message = "providerId is required")
    private UUID providerId;

    @NotBlank(message = "methodPayment is required")
    private String methodPayment;

    @NotBlank(message = "observations is required")
    private String observations;

    @Valid
    @NotNull(message = "purchaseDetailModelList is required")
    private List<RequestPurchaseDetailsDto> requestPurchaseDetailsDtoList;
}
