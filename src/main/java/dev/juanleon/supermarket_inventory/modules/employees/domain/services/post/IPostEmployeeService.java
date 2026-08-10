package dev.juanleon.supermarket_inventory.modules.employees.domain.services.post;

import dev.juanleon.supermarket_inventory.share.utils.dto.InputFileDto;
import dev.juanleon.supermarket_inventory.modules.employees.domain.models.EmployeeModel;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseModel;

public interface IPostEmployeeService {
    ResponseModel registerEmployeeAndUser(EmployeeModel employeeModel, InputFileDto inputFileDto);
}
