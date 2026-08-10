package dev.juanleon.supermarket_inventory.modules.sales.domain.useCases.post;

import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.modules.employees.domain.models.EmployeeModel;
import dev.juanleon.supermarket_inventory.modules.products.domain.models.ProductModel;
import dev.juanleon.supermarket_inventory.modules.sales.domain.business.SalesAssignment;
import dev.juanleon.supermarket_inventory.modules.sales.domain.business.SalesCalculator;
import dev.juanleon.supermarket_inventory.modules.sales.domain.models.SalesModel;
import dev.juanleon.supermarket_inventory.modules.sales.domain.persistence.post.IPostSalesPersistence;
import dev.juanleon.supermarket_inventory.modules.sales.domain.ports.IEmployeeProviderSales;
import dev.juanleon.supermarket_inventory.modules.sales.domain.ports.IProductProviderSales;
import dev.juanleon.supermarket_inventory.modules.sales.domain.services.post.IPostSalesServices;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class PostSalesUseCases implements IPostSalesServices {

    private final IPostSalesPersistence iPostSalesPersistence;
    private final IEmployeeProviderSales iEmployeeProviderSales;
    private final IProductProviderSales iProductProviderSales;

    public PostSalesUseCases(IPostSalesPersistence iPostSalesPersistence, IEmployeeProviderSales iEmployeeProviderSales, IProductProviderSales iProductProviderSales) {
        this.iPostSalesPersistence = iPostSalesPersistence;
        this.iEmployeeProviderSales = iEmployeeProviderSales;
        this.iProductProviderSales = iProductProviderSales;
    }

    @Override
    public ResponseModel create(SalesModel salesModel, UUID employeeId) {

        EmployeeModel employeeModel = this.iEmployeeProviderSales.getEmployeeById(employeeId);
        salesModel.setEmployeeModel(employeeModel);

        List<UUID> idList = SalesAssignment.getListIds(salesModel);

        List<ProductModel> productModelList = this.iProductProviderSales.getProductsByIds(idList);

        SalesModel salesAssignment = SalesAssignment.salesAssignment(salesModel, productModelList);

        SalesModel salesModelCalculated = SalesCalculator.calculateAllSales(salesAssignment);

        salesModelCalculated.setNumberSale(UUID.randomUUID());
        salesModelCalculated.setDateSale(LocalDateTime.now());

        String response = this.iPostSalesPersistence.create(salesModelCalculated);
        return new ResponseModel(response);
    }
}
