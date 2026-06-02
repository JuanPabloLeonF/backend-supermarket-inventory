package dev.juanleon.supermarket_inventory.sales.domain.models;

import dev.juanleon.supermarket_inventory.employees.domain.models.EmployeeModel;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class SalesModel {
    private UUID id;
    private EmployeeModel employeeModel;
    private UUID numberSale;
    private LocalDateTime dateSale;
    private BigDecimal subTotal;
    private BigDecimal discount;
    private BigDecimal iva;
    private BigDecimal total;
    private String methodPayment;
    private String status;

    private SalesModel(SalesModelBuilder builder) {
        this.id = builder.id;
        this.employeeModel = builder.employeeModel;
        this.numberSale = builder.numberSale;
        this.dateSale = builder.dateSale;
        this.subTotal = builder.subTotal;
        this.discount = builder.discount;
        this.iva = builder.iva;
        this.total = builder.total;
        this.methodPayment = builder.methodPayment;
        this.status = builder.status;
    }

    public static SalesModelBuilder builder() {
        return new SalesModelBuilder();
    }

    public static class SalesModelBuilder {
        public UUID id;
        public EmployeeModel employeeModel;
        public UUID numberSale;
        public LocalDateTime dateSale;
        public BigDecimal subTotal;
        public BigDecimal discount;
        public BigDecimal iva;
        public BigDecimal total;
        public String methodPayment;
        public String status;

        public SalesModelBuilder id(UUID id) {
            this.id = id;
            return this;
        }

        public SalesModelBuilder employeeModel(EmployeeModel employeeModel) {
            this.employeeModel = employeeModel;
            return this;
        }

        public SalesModelBuilder numberSale(UUID numberSale) {
            this.numberSale = numberSale;
            return this;
        }

        public SalesModelBuilder dateSale(LocalDateTime dateSale) {
            this.dateSale = dateSale;
            return this;
        }

        public SalesModelBuilder subTotal(BigDecimal subTotal) {
            this.subTotal = subTotal;
            return this;
        }

        public SalesModelBuilder discount(BigDecimal discount) {
            this.discount = discount;
            return this;
        }

        public SalesModelBuilder iva(BigDecimal iva) {
            this.iva = iva;
            return this;
        }

        public SalesModelBuilder total(BigDecimal total) {
            this.total = total;
            return this;
        }

        public SalesModelBuilder methodPayment(String methodPayment) {
            this.methodPayment = methodPayment;
            return this;
        }

        public SalesModelBuilder status(String status) {
            this.status = status;
            return this;
        }

        public SalesModel build() {
            return new SalesModel(this);
        }
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

    public UUID getNumberSale() {
        return numberSale;
    }

    public void setNumberSale(UUID numberSale) {
        this.numberSale = numberSale;
    }

    public LocalDateTime getDateSale() {
        return dateSale;
    }

    public void setDateSale(LocalDateTime dateSale) {
        this.dateSale = dateSale;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    public BigDecimal getIva() {
        return iva;
    }

    public void setIva(BigDecimal iva) {
        this.iva = iva;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SalesModel{" +
                "id=" + id +
                ", employeeModel=" + employeeModel +
                ", numberSale=" + numberSale +
                ", dateSale=" + dateSale +
                ", subTotal=" + subTotal +
                ", discount=" + discount +
                ", iva=" + iva +
                ", total=" + total +
                ", methodPayment='" + methodPayment + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
