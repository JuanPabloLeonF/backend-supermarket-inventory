package dev.juanleon.supermarket_inventory.modules.purchases.application.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import dev.juanleon.supermarket_inventory.modules.employees.domain.models.EmployeeModel;
import dev.juanleon.supermarket_inventory.modules.providers.domain.models.ProviderModel;
import dev.juanleon.supermarket_inventory.modules.purchases.domain.models.PurchaseDetailsModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponsePurchaseDto {
    private UUID id;
    private EmployeeModel employeeModel;
    private ProviderModel providerModel;
    private UUID numberPurchase;
    private BigDecimal iva;
    private BigDecimal subTotal;
    private BigDecimal total;
    private BigDecimal discount;
    private String methodPayment;
    private String observations;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate datePurchase;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdAt;
    private List<PurchaseDetailsModel> purchaseDetailModelList;
}
