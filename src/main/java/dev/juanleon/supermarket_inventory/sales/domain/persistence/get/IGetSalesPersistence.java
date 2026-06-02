package dev.juanleon.supermarket_inventory.sales.domain.persistence.get;

import dev.juanleon.supermarket_inventory.common.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.common.utils.dto.PaginationRequest;
import dev.juanleon.supermarket_inventory.sales.domain.models.SalesModel;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public interface IGetSalesPersistence {
    PagedResponse<SalesModel> getAll(PaginationRequest paginationRequest);
    PagedResponse<SalesModel> getAllByEmployeeId(UUID employeeId, PaginationRequest paginationRequest);
    PagedResponse<SalesModel> getAllByDateSale(LocalDateTime dateSale, PaginationRequest paginationRequest);
    PagedResponse<SalesModel> getAllByMethodPayment(String methodPayment, PaginationRequest paginationRequest);
    PagedResponse<SalesModel> getAllByStatus(String status, PaginationRequest paginationRequest);
    PagedResponse<SalesModel> getAllByDiscount(BigDecimal discount, PaginationRequest paginationRequest);
    SalesModel getById(UUID id);
    SalesModel getByNumberSale(UUID numberSale);
}
