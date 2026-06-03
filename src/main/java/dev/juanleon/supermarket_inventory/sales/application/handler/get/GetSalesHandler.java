package dev.juanleon.supermarket_inventory.sales.application.handler.get;

import dev.juanleon.supermarket_inventory.common.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.common.utils.dto.PaginationRequest;
import dev.juanleon.supermarket_inventory.common.utils.mappers.IMapperPaginationApp;
import dev.juanleon.supermarket_inventory.sales.application.dto.SalesResponseDTO;
import dev.juanleon.supermarket_inventory.sales.application.mappers.IMapperSalesApplication;
import dev.juanleon.supermarket_inventory.sales.domain.services.get.IGetSalesServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetSalesHandler implements IGetSalesHandler {

    private final IGetSalesServices iGetSalesServices;
    private final IMapperSalesApplication iMapperSalesApplication;
    private final IMapperPaginationApp iMapperPaginationApp;

    @Override
    public PagedResponse<SalesResponseDTO> getAll(PaginationRequest paginationRequest) {
        return this.iMapperPaginationApp.pageResponseToPageResponseTypeResponse(
                this.iGetSalesServices.getAll(paginationRequest),
                this.iMapperSalesApplication::toResponse
        );
    }

    @Override
    public PagedResponse<SalesResponseDTO> getAllByEmployeeId(UUID employeeId, PaginationRequest paginationRequest) {
        return this.iMapperPaginationApp.pageResponseToPageResponseTypeResponse(
                this.iGetSalesServices.getAllByEmployeeId(employeeId, paginationRequest),
                this.iMapperSalesApplication::toResponse
        );
    }

    @Override
    public PagedResponse<SalesResponseDTO> getAllByDateSale(LocalDateTime dateSale, PaginationRequest paginationRequest) {
        return this.iMapperPaginationApp.pageResponseToPageResponseTypeResponse(
                this.iGetSalesServices.getAllByDateSale(dateSale, paginationRequest),
                this.iMapperSalesApplication::toResponse
        );
    }

    @Override
    public PagedResponse<SalesResponseDTO> getAllByMethodPayment(String methodPayment, PaginationRequest paginationRequest) {
        return this.iMapperPaginationApp.pageResponseToPageResponseTypeResponse(
                this.iGetSalesServices.getAllByMethodPayment(methodPayment, paginationRequest),
                this.iMapperSalesApplication::toResponse
        );
    }

    @Override
    public PagedResponse<SalesResponseDTO> getAllByStatus(String status, PaginationRequest paginationRequest) {
        return this.iMapperPaginationApp.pageResponseToPageResponseTypeResponse(
                this.iGetSalesServices.getAllByStatus(status, paginationRequest),
                this.iMapperSalesApplication::toResponse
        );
    }

    @Override
    public PagedResponse<SalesResponseDTO> getAllByDiscount(BigDecimal discount, PaginationRequest paginationRequest) {
        return this.iMapperPaginationApp.pageResponseToPageResponseTypeResponse(
                this.iGetSalesServices.getAllByDiscount(discount, paginationRequest),
                this.iMapperSalesApplication::toResponse
        );
    }

    @Override
    public SalesResponseDTO getById(UUID id) {
        return this.iMapperSalesApplication.toResponse(this.iGetSalesServices.getById(id));
    }

    @Override
    public SalesResponseDTO getByNumberSale(UUID numberSale) {
        return this.iMapperSalesApplication.toResponse(this.iGetSalesServices.getByNumberSale(numberSale));
    }
}
