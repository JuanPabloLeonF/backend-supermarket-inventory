package dev.juanleon.supermarket_inventory.sales_details.domain.models;

import dev.juanleon.supermarket_inventory.sales.domain.models.SalesModel;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class SalesDetailsModel {

    private UUID id;
    private SalesModel salesModel;
    private UUID numberSale;
    private LocalDateTime dateSale;
    private BigDecimal subTotal;
    private BigDecimal discount;
    private BigDecimal iva;
    private BigDecimal total;
    private String methodPayment;
    private String status;
}
