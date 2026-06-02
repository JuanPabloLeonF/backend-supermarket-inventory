package dev.juanleon.supermarket_inventory.sales.infrastructure.outputs.database.adapters.get;

import dev.juanleon.supermarket_inventory.common.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.common.utils.dto.PaginationRequest;
import dev.juanleon.supermarket_inventory.common.utils.mappers.IMapperPaginationApp;
import dev.juanleon.supermarket_inventory.sales.domain.models.SalesModel;
import dev.juanleon.supermarket_inventory.sales.domain.persistence.get.IGetSalesPersistence;
import dev.juanleon.supermarket_inventory.sales.infrastructure.outputs.database.entities.SalesEntity;
import dev.juanleon.supermarket_inventory.sales.infrastructure.outputs.database.mappers.IMapperSalesInfrastructure;
import dev.juanleon.supermarket_inventory.sales.infrastructure.outputs.database.repositories.ISalesRepository;
import dev.juanleon.supermarket_inventory.sales.infrastructure.outputs.exceptions.NotFoundSalesException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class GetSalesAdapter implements IGetSalesPersistence {

    private final ISalesRepository iSalesRepository;
    private final IMapperSalesInfrastructure iMapperSalesInfrastructure;
    private final IMapperPaginationApp iMapperPaginationApp;

    @Override
    public PagedResponse<SalesModel> getAll(PaginationRequest paginationRequest) {
        Pageable pageable = this.iMapperPaginationApp.toPageable(paginationRequest);
        Page<SalesEntity> entityPage = this.iSalesRepository.findAll(pageable);
        return this.iMapperPaginationApp.pagetoPagedResponse(
                entityPage,
                this.iMapperSalesInfrastructure::toModel
        );
    }

    @Override
    public PagedResponse<SalesModel> getAllByEmployeeId(UUID employeeId, PaginationRequest paginationRequest) {
        Pageable pageable = this.iMapperPaginationApp.toPageable(paginationRequest);
        Page<SalesEntity> entityPage = this.iSalesRepository.findByEmployee_Id(employeeId, pageable);
        return this.iMapperPaginationApp.pagetoPagedResponse(
                entityPage,
                this.iMapperSalesInfrastructure::toModel
        );
    }

    @Override
    public PagedResponse<SalesModel> getAllByDateSale(LocalDateTime dateSale, PaginationRequest paginationRequest) {
        Pageable pageable = this.iMapperPaginationApp.toPageable(paginationRequest);
        Page<SalesEntity> entityPage = this.iSalesRepository.findByDateSaleGreaterThanEqual(dateSale, pageable);
        return this.iMapperPaginationApp.pagetoPagedResponse(
                entityPage,
                this.iMapperSalesInfrastructure::toModel
        );
    }

    @Override
    public PagedResponse<SalesModel> getAllByMethodPayment(String methodPayment, PaginationRequest paginationRequest) {
        Pageable pageable = this.iMapperPaginationApp.toPageable(paginationRequest);
        Page<SalesEntity> entityPage = this.iSalesRepository.findByMethodPayment(methodPayment, pageable);
        return this.iMapperPaginationApp.pagetoPagedResponse(
                entityPage,
                this.iMapperSalesInfrastructure::toModel
        );
    }

    @Override
    public PagedResponse<SalesModel> getAllByStatus(String status, PaginationRequest paginationRequest) {
        Pageable pageable = this.iMapperPaginationApp.toPageable(paginationRequest);
        Page<SalesEntity> entityPage = this.iSalesRepository.findByStatus(status, pageable);
        return this.iMapperPaginationApp.pagetoPagedResponse(
                entityPage,
                this.iMapperSalesInfrastructure::toModel
        );
    }

    @Override
    public PagedResponse<SalesModel> getAllByDiscount(BigDecimal discount, PaginationRequest paginationRequest) {
        Pageable pageable = this.iMapperPaginationApp.toPageable(paginationRequest);
        Page<SalesEntity> entityPage = this.iSalesRepository.findByDiscountGreaterThanEqual(discount, pageable);
        return this.iMapperPaginationApp.pagetoPagedResponse(
                entityPage,
                this.iMapperSalesInfrastructure::toModel
        );
    }

    @Override
    public SalesModel getById(UUID id) {
        return this.iSalesRepository.findById(id)
                .map(this.iMapperSalesInfrastructure::toModel)
                .orElseThrow(() -> new NotFoundSalesException(id));
    }

    @Override
    public SalesModel getByNumberSale(UUID numberSale) {
        return this.iSalesRepository.findByNumberSale(numberSale)
                .map(this.iMapperSalesInfrastructure::toModel)
                .orElseThrow(() -> new NotFoundSalesException(numberSale));
    }
}
