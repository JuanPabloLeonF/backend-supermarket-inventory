package dev.juanleon.supermarket_inventory.reports.domain.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class SaleReportDto {

    private String customerName;
    private String customerId;
    private String employeeName;
    private LocalDateTime createdAt;
    private String paymentType;
    private List<SaleItemDto> items;
    private BigDecimal subtotal;
    private BigDecimal taxAmount;
    private BigDecimal total;

    public SaleReportDto() {
    }

    public SaleReportDto(String customerName, String customerId, String employeeName, LocalDateTime createdAt, String paymentType, List<SaleItemDto> items, BigDecimal subtotal, BigDecimal taxAmount, BigDecimal total) {
        this.customerName = customerName;
        this.customerId = customerId;
        this.employeeName = employeeName;
        this.createdAt = createdAt;
        this.paymentType = paymentType;
        this.items = items;
        this.subtotal = subtotal;
        this.taxAmount = taxAmount;
        this.total = total;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<SaleItemDto> getItems() {
        return items;
    }

    public void setItems(List<SaleItemDto> items) {
        this.items = items;
    }

    public BigDecimal getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(BigDecimal taxAmount) {
        this.taxAmount = taxAmount;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
