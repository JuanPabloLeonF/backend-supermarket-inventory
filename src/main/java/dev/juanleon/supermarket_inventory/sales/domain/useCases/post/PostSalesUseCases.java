package dev.juanleon.supermarket_inventory.sales.domain.useCases.post;

import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.employees.domain.models.EmployeeModel;
import dev.juanleon.supermarket_inventory.sales.domain.business.SalesCalculator;
import dev.juanleon.supermarket_inventory.sales.domain.models.SalesModel;
import dev.juanleon.supermarket_inventory.sales.domain.persistence.post.IPostSalesPersistence;
import dev.juanleon.supermarket_inventory.sales.domain.ports.IEmployeeProviderSales;
import dev.juanleon.supermarket_inventory.sales.domain.services.post.IPostSalesServices;

import java.time.LocalDateTime;
import java.util.UUID;

public class PostSalesUseCases implements IPostSalesServices {

    private final IPostSalesPersistence iPostSalesPersistence;
    private final IEmployeeProviderSales iEmployeeProviderSales;

    public PostSalesUseCases(IPostSalesPersistence iPostSalesPersistence, IEmployeeProviderSales iEmployeeProviderSales) {
        this.iPostSalesPersistence = iPostSalesPersistence;
        this.iEmployeeProviderSales = iEmployeeProviderSales;
    }

    @Override
    public ResponseModel create(SalesModel salesModel, UUID employeeId) {
        EmployeeModel employeeModel = this.iEmployeeProviderSales.getEmployeeById(employeeId);

        salesModel.setEmployeeModel(employeeModel);
        salesModel.setNumberSale(UUID.randomUUID());
        salesModel.setDateSale(LocalDateTime.now());

        SalesModel salesModelCalculated = SalesCalculator.calculateAllSales(salesModel);

        String response = this.iPostSalesPersistence.create(salesModelCalculated);
        return new ResponseModel(response);
    }
}
