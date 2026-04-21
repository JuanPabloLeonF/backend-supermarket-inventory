package dev.juanleon.supermarket_inventory.cash_register.domain.models;

import dev.juanleon.supermarket_inventory.employees.domain.models.EmployeeModel;

import java.util.UUID;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CashRegisterModel {

    private UUID id;
    private EmployeeModel employee;
    private LocalDateTime openingTime;
    private LocalDateTime closingTime;
    private BigDecimal initialAmount;
    private BigDecimal finalAmount;
    private BigDecimal totalSales;
    private BigDecimal totalPurchases;
    private BigDecimal difference;
    private String observations;

    public CashRegisterModel() {
    }

    public CashRegisterModel(UUID id, EmployeeModel employee, LocalDateTime openingTime, LocalDateTime closingTime,
                             BigDecimal initialAmount, BigDecimal finalAmount, BigDecimal totalSales,
                             BigDecimal totalPurchases, BigDecimal difference, String observations) {
        this.id = id;
        this.employee = employee;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.initialAmount = initialAmount;
        this.finalAmount = finalAmount;
        this.totalSales = totalSales;
        this.totalPurchases = totalPurchases;
        this.difference = difference;
        this.observations = observations;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public EmployeeModel getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeModel employee) {
        this.employee = employee;
    }

    public LocalDateTime getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(LocalDateTime openingTime) {
        this.openingTime = openingTime;
    }

    public LocalDateTime getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(LocalDateTime closingTime) {
        this.closingTime = closingTime;
    }

    public BigDecimal getInitialAmount() {
        return initialAmount;
    }

    public void setInitialAmount(BigDecimal initialAmount) {
        this.initialAmount = initialAmount;
    }

    public BigDecimal getFinalAmount() {
        return finalAmount;
    }

    public void setFinalAmount(BigDecimal finalAmount) {
        this.finalAmount = finalAmount;
    }

    public BigDecimal getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(BigDecimal totalSales) {
        this.totalSales = totalSales;
    }

    public BigDecimal getTotalPurchases() {
        return totalPurchases;
    }

    public void setTotalPurchases(BigDecimal totalPurchases) {
        this.totalPurchases = totalPurchases;
    }

    public BigDecimal getDifference() {
        return difference;
    }

    public void setDifference(BigDecimal difference) {
        this.difference = difference;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    @Override
    public String toString() {
        return "CashRegisterModel{" +
                "id=" + id +
                ", employee=" + employee +
                ", openingTime=" + openingTime +
                ", closingTime=" + closingTime +
                ", initialAmount=" + initialAmount +
                ", finalAmount=" + finalAmount +
                ", totalSales=" + totalSales +
                ", totalPurchases=" + totalPurchases +
                ", difference=" + difference +
                ", observations='" + observations + '\'' +
                '}';
    }
}
