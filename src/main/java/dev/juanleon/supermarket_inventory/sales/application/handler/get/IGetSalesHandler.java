package dev.juanleon.supermarket_inventory.sales.application.handler.get;

import dev.juanleon.supermarket_inventory.common.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.common.utils.dto.PaginationRequest;
import dev.juanleon.supermarket_inventory.sales.application.dto.SalesResponseDTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public interface IGetSalesHandler {
    PagedResponse<SalesResponseDTO> getAll(PaginationRequest paginationRequest);
    PagedResponse<SalesResponseDTO> getAllByEmployeeId(UUID employeeId, PaginationRequest paginationRequest);
    PagedResponse<SalesResponseDTO> getAllByDateSale(LocalDateTime dateSale, PaginationRequest paginationRequest);
    PagedResponse<SalesResponseDTO> getAllByMethodPayment(String methodPayment, PaginationRequest paginationRequest);
    PagedResponse<SalesResponseDTO> getAllByStatus(String status, PaginationRequest paginationRequest);
    PagedResponse<SalesResponseDTO> getAllByDiscount(BigDecimal discount, PaginationRequest paginationRequest);
    SalesResponseDTO getById(UUID id);
    SalesResponseDTO getByNumberSale(UUID numberSale);
}
