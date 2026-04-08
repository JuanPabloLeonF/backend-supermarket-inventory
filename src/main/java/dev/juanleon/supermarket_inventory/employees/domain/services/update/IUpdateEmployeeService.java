package dev.juanleon.supermarket_inventory.employees.domain.services.update;

import dev.juanleon.supermarket_inventory.common.utils.dto.InputFileDto;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.employees.domain.models.EmployeeModel;

import java.util.UUID;

public interface IUpdateEmployeeService {
    ResponseModel updateByIdEmployeeAndUser(EmployeeModel employeeModel);
    ResponseModel updateByIdImage(UUID id, InputFileDto inputFileDto);
}
