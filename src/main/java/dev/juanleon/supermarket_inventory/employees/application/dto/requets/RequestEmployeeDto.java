package dev.juanleon.supermarket_inventory.employees.application.dto.requets;

import com.fasterxml.jackson.annotation.JsonFormat;
import dev.juanleon.supermarket_inventory.users.application.dto.RequestUserDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestEmployeeDto {

    @Valid
    @NotNull(message = "User data is required")
    private RequestUserDto requestUserDto;

    @NotBlank(message = "NationalId is required")
    @Size(min = 8, max = 10, message = "NationalId must be between 8 and 10 characters")
    private String nationalId;

    @NotBlank(message = "Phone is required")
    @Size(min = 12, max = 16, message = "Phone length is invalid for international format")
    @Pattern(
            regexp = "^\\+\\d{1,3}\\s\\d{10}$",
            message = "Phone must follow the format: +[country code] [10 digits], e.g., +57 3228843600"
    )
    private String phone;

    @NotBlank(message = "address is required")
    @Size(min = 2, max = 200, message = "address must be between 2 and 200 characters")
    private String address;

    @NotNull(message = "Image is required")
    private MultipartFile imgFile;

    @NotBlank(message = "Position is required")
    @Size(min = 2, max = 100, message = "Position must be between 2 and 100 characters")
    private String position;

    @NotNull(message = "Salary is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Salary must be greater than 0")
    @Digits(integer = 10, fraction = 2, message = "Salary has an invalid format")
    private BigDecimal salary;

    @NotNull(message = "Hire date is required")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate hireDate;
}
