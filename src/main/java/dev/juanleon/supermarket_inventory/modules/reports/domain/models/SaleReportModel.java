package dev.juanleon.supermarket_inventory.modules.reports.domain.models;

import dev.juanleon.supermarket_inventory.modules.sales.domain.models.SalesModel;

import java.util.UUID;

public class SaleReportModel {

    private String customerName;
    private String identificationCustomer;
    private SalesModel salesModel;
    private UUID employeeId;

    public SaleReportModel() {
    }

    public SaleReportModel(String customerName, String identificationCustomer, SalesModel salesModel, UUID employeeId) {
        this.customerName = customerName;
        this.identificationCustomer = identificationCustomer;
        this.salesModel = salesModel;
        this.employeeId = employeeId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getIdentificationCustomer() {
        return identificationCustomer;
    }

    public void setIdentificationCustomer(String identificationCustomer) {
        this.identificationCustomer = identificationCustomer;
    }

    public SalesModel getSalesModel() {
        return salesModel;
    }

    public void setSalesModel(SalesModel salesModel) {
        this.salesModel = salesModel;
    }

    public UUID getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(UUID employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return "SaleReportModel{" +
                "customerName='" + customerName + '\'' +
                ", identificationCustomer='" + identificationCustomer + '\'' +
                ", salesModel=" + salesModel +
                ", employeeId=" + employeeId +
                '}';
    }
}
