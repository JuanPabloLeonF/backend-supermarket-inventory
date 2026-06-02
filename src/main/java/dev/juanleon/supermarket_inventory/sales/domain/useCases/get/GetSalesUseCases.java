package dev.juanleon.supermarket_inventory.sales.domain.useCases.get;

import dev.juanleon.supermarket_inventory.common.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.common.utils.dto.PaginationRequest;
import dev.juanleon.supermarket_inventory.sales.domain.models.SalesModel;
import dev.juanleon.supermarket_inventory.sales.domain.persistence.get.IGetSalesPersistence;
import dev.juanleon.supermarket_inventory.sales.domain.services.get.IGetSalesServices;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class GetSalesUseCases implements IGetSalesServices {

    private final IGetSalesPersistence iGetSalesPersistence;

    public GetSalesUseCases(IGetSalesPersistence iGetSalesPersistence) {
        this.iGetSalesPersistence = iGetSalesPersistence;
    }

    @Override
    public PagedResponse<SalesModel> getAll(PaginationRequest paginationRequest) {
        return this.iGetSalesPersistence.getAll(paginationRequest);
    }

    @Override
    public PagedResponse<SalesModel> getAllByEmployeeId(UUID employeeId, PaginationRequest paginationRequest) {
        return this.iGetSalesPersistence.getAllByEmployeeId(employeeId, paginationRequest);
    }

    @Override
    public PagedResponse<SalesModel> getAllByDateSale(LocalDateTime dateSale, PaginationRequest paginationRequest) {
        return this.iGetSalesPersistence.getAllByDateSale(dateSale, paginationRequest);
    }

    @Override
    public PagedResponse<SalesModel> getAllByMethodPayment(String methodPayment, PaginationRequest paginationRequest) {
        return this.iGetSalesPersistence.getAllByMethodPayment(methodPayment, paginationRequest);
    }

    @Override
    public PagedResponse<SalesModel> getAllByStatus(String status, PaginationRequest paginationRequest) {
        return this.iGetSalesPersistence.getAllByStatus(status, paginationRequest);
    }

    @Override
    public PagedResponse<SalesModel> getAllByDiscount(BigDecimal discount, PaginationRequest paginationRequest) {
        return this.iGetSalesPersistence.getAllByDiscount(discount, paginationRequest);
    }

    @Override
    public SalesModel getById(UUID id) {
        return this.iGetSalesPersistence.getById(id);
    }

    @Override
    public SalesModel getByNumberSale(UUID numberSale) {
        return this.iGetSalesPersistence.getByNumberSale(numberSale);
    }
}
