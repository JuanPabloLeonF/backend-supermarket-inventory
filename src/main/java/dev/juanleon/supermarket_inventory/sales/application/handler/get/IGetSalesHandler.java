package dev.juanleon.supermarket_inventory.sales.application.handler.get;

import dev.juanleon.supermarket_inventory.common.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.common.utils.dto.PaginationRequest;
import dev.juanleon.supermarket_inventory.sales.application.dto.ResponseSalesDto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public interface IGetSalesHandler {
    PagedResponse<ResponseSalesDto> getAll(PaginationRequest paginationRequest);
    PagedResponse<ResponseSalesDto> getAllByEmployeeId(UUID employeeId, PaginationRequest paginationRequest);
    PagedResponse<ResponseSalesDto> getAllByDateSale(LocalDateTime dateSale, PaginationRequest paginationRequest);
    PagedResponse<ResponseSalesDto> getAllByMethodPayment(String methodPayment, PaginationRequest paginationRequest);
    PagedResponse<ResponseSalesDto> getAllByStatus(String status, PaginationRequest paginationRequest);
    PagedResponse<ResponseSalesDto> getAllByDiscount(BigDecimal discount, PaginationRequest paginationRequest);
    ResponseSalesDto getById(UUID id);
    ResponseSalesDto getByNumberSale(UUID numberSale);
}
