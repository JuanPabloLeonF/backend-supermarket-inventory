package dev.juanleon.supermarket_inventory.modules.sales.application.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import dev.juanleon.supermarket_inventory.modules.employees.application.dto.responses.ResponseEmployeeDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseSalesDto {
    private UUID id;
    private ResponseEmployeeDto employee;
    private UUID numberSale;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateSale;
    private BigDecimal subTotal;
    private BigDecimal discount;
    private BigDecimal iva;
    private BigDecimal total;
    private String methodPayment;
    private List<ResponseSalesDetailsDto> responseSalesDetailsDtoList;
}
