package dev.juanleon.supermarket_inventory.sales.domain.useCases.post;

import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.employees.domain.models.EmployeeModel;
import dev.juanleon.supermarket_inventory.employees.domain.services.get.IGetEmployeeService;
import dev.juanleon.supermarket_inventory.sales.domain.models.SalesModel;
import dev.juanleon.supermarket_inventory.sales.domain.persistence.post.IPostSalesPersistence;
import dev.juanleon.supermarket_inventory.sales.domain.services.post.IPostSalesServices;

import java.util.UUID;

public class PostSalesUseCases implements IPostSalesServices {

    private final IPostSalesPersistence iPostSalesPersistence;
    private final IGetEmployeeService iGetEmployeeService;

    public PostSalesUseCases(IPostSalesPersistence iPostSalesPersistence, IGetEmployeeService iGetEmployeeService) {
        this.iPostSalesPersistence = iPostSalesPersistence;
        this.iGetEmployeeService = iGetEmployeeService;
    }

    @Override
    public ResponseModel create(SalesModel salesModel, UUID employeeId) {
        EmployeeModel employeeModel = this.iGetEmployeeService.getById(employeeId);
        salesModel.setEmployeeModel(employeeModel);
        String response = this.iPostSalesPersistence.create(salesModel);
        return new ResponseModel(response);
    }
}
