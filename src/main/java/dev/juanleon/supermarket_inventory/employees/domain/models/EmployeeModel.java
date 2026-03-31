package dev.juanleon.supermarket_inventory.employees.domain.models;

import dev.juanleon.supermarket_inventory.users.domain.models.UserModel;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record EmployeeModel(
        UUID id,
        UserModel userModel,
        String nationalId,
        String phone,
        String address,
        String urlImg,
        String position,
        BigDecimal salary,
        LocalDate hireDate
) {}