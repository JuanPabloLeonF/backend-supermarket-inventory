package dev.juanleon.supermarket_inventory.reports.application.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import dev.juanleon.supermarket_inventory.employees.application.dto.responses.ResponseEmployeeDto;
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
public class ResponseReport {
    private UUID id;
    private ResponseEmployeeDto employee;
    private String reportType;
    private String period;
    private String filePath;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime generatedAt;
}
