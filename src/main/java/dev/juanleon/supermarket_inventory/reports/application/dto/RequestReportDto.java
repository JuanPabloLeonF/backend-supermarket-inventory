package dev.juanleon.supermarket_inventory.reports.application.dto;

import dev.juanleon.supermarket_inventory.employees.infrastructure.outputs.database.entities.EmployeeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestReportDto {
    private UUID id;
    private EmployeeEntity employee;
    private String reportType;
    private String period;
    private String filePath;
    private LocalDateTime generatedAt;
}
