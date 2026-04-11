package dev.juanleon.supermarket_inventory.reports.domain.models;

import dev.juanleon.supermarket_inventory.employees.infrastructure.outputs.database.entities.EmployeeEntity;

import java.time.LocalDateTime;
import java.util.UUID;

public class ReportModel {

    private UUID id;
    private EmployeeEntity employee;
    private String reportType;
    private String period;
    private String filePath;
    private LocalDateTime generatedAt;

    public ReportModel(){}

    public ReportModel(UUID id, EmployeeEntity employee, String reportType, String period, String filePath, LocalDateTime generatedAt) {
        this.id = id;
        this.employee = employee;
        this.reportType = reportType;
        this.period = period;
        this.filePath = filePath;
        this.generatedAt = generatedAt;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public EmployeeEntity getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public LocalDateTime getGeneratedAt() {
        return generatedAt;
    }

    public void setGeneratedAt(LocalDateTime generatedAt) {
        this.generatedAt = generatedAt;
    }
}
