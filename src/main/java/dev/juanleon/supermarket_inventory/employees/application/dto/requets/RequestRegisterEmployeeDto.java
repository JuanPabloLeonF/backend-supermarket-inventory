package dev.juanleon.supermarket_inventory.employees.application.dto.requets;

import dev.juanleon.supermarket_inventory.common.utils.dto.InputFileDto;
import dev.juanleon.supermarket_inventory.users.application.dto.RequestUserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestRegisterEmployeeDto {
    private RequestUserDto requestUserDto;
    private String nationalId;
    private String phone;
    private String address;
    private InputFileDto inputFileDto;
    private String position;
    private BigDecimal salary;
    private LocalDate hireDate;
}
