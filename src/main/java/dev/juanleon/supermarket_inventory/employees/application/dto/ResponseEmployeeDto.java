package dev.juanleon.supermarket_inventory.employees.application.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import dev.juanleon.supermarket_inventory.users.application.dto.ResponseUserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseEmployeeDto {
    private UUID id;
    private ResponseUserDto responseUserDto;
    private String nationalId;
    private String phone;
    private String address;
    private String urlImg;
    private String position;
    private BigDecimal salary;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate hireDate;
}
