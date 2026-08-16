package dev.juanleon.supermarket_inventory.modules.purchases.domain.models;

import dev.juanleon.supermarket_inventory.modules.employees.domain.models.EmployeeModel;
import dev.juanleon.supermarket_inventory.modules.providers.domain.models.ProviderModel;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class PurchaseModel {

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
    private LocalDate datePurchase;
    private LocalDate createdAt;
    private List<PurchaseDetailsModel> purchaseDetailModelList;

    public PurchaseModel() {}

    public PurchaseModel(UUID id, EmployeeModel employeeModel, ProviderModel providerModel, UUID numberPurchase, BigDecimal iva, BigDecimal subTotal, BigDecimal total, BigDecimal discount, String methodPayment, LocalDate datePurchase, String observations, LocalDate createdAt, List<PurchaseDetailsModel> purchaseDetailModelList) {
        this.id = id;
        this.employeeModel = employeeModel;
        this.providerModel = providerModel;
        this.numberPurchase = numberPurchase;
        this.iva = iva;
        this.subTotal = subTotal;
        this.total = total;
        this.discount = discount;
        this.methodPayment = methodPayment;
        this.datePurchase = datePurchase;
        this.observations = observations;
        this.createdAt = createdAt;
        this.purchaseDetailModelList = purchaseDetailModelList;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public EmployeeModel getEmployeeModel() {
        return employeeModel;
    }

    public void setEmployeeModel(EmployeeModel employeeModel) {
        this.employeeModel = employeeModel;
    }

    public ProviderModel getProviderModel() {
        return providerModel;
    }

    public void setProviderModel(ProviderModel providerModel) {
        this.providerModel = providerModel;
    }

    public UUID getNumberPurchase() {
        return numberPurchase;
    }

    public void setNumberPurchase(UUID numberPurchase) {
        this.numberPurchase = numberPurchase;
    }

    public BigDecimal getIva() {
        return iva;
    }

    public void setIva(BigDecimal iva) {
        this.iva = iva;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getMethodPayment() {
        return methodPayment;
    }

    public void setMethodPayment(String methodPayment) {
        this.methodPayment = methodPayment;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public LocalDate getDatePurchase() {
        return datePurchase;
    }

    public void setDatePurchase(LocalDate datePurchase) {
        this.datePurchase = datePurchase;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public List<PurchaseDetailsModel> getPurchaseDetailModelList() {
        return purchaseDetailModelList;
    }

    public void setPurchaseDetailModelList(List<PurchaseDetailsModel> purchaseDetailModelList) {
        this.purchaseDetailModelList = purchaseDetailModelList;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "PurchaseModel{" +
                "id=" + id +
                ", employeeModel=" + employeeModel +
                ", providerModel=" + providerModel +
                ", numberPurchase=" + numberPurchase +
                ", iva=" + iva +
                ", subTotal=" + subTotal +
                ", total=" + total +
                ", methodPayment='" + methodPayment + '\'' +
                ", observations='" + observations + '\'' +
                ", datePurchase=" + datePurchase +
                ", createdAt=" + createdAt +
                ", discount=" + discount +
                ", purchaseDetailModelList=" + purchaseDetailModelList +
                '}';
    }
}
