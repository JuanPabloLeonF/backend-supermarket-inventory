package dev.juanleon.supermarket_inventory.cash_register.infrastructure.outputs.database.adapters.get;

import dev.juanleon.supermarket_inventory.cash_register.domain.models.CashRegisterModel;
import dev.juanleon.supermarket_inventory.cash_register.domain.persistence.get.IGetCashRegisterPersistence;
import dev.juanleon.supermarket_inventory.cash_register.infrastructure.outputs.database.entities.CashRegisterEntity;
import dev.juanleon.supermarket_inventory.cash_register.infrastructure.outputs.database.mappers.IMapperCashRegisterInfrastructure;
import dev.juanleon.supermarket_inventory.cash_register.infrastructure.outputs.database.repositories.ICashRegisterRepository;
import dev.juanleon.supermarket_inventory.cash_register.infrastructure.outputs.exceptions.NotFoundCashRegisterException;
import dev.juanleon.supermarket_inventory.common.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.common.utils.dto.PaginationRequest;
import dev.juanleon.supermarket_inventory.common.utils.mappers.IMapperPaginationApp;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class CashRegisterAdapter implements IGetCashRegisterPersistence {

    private final ICashRegisterRepository iCashRegisterRepository;
    private final IMapperCashRegisterInfrastructure iMapperCashRegisterInfrastructure;
    private final IMapperPaginationApp iMapperPaginationApp;

    @Override
    public CashRegisterModel getById(UUID id) {
        return this.iCashRegisterRepository.findById(id)
                .map(iMapperCashRegisterInfrastructure::toModel)
                .orElseThrow(() -> new NotFoundCashRegisterException(id));
    }

    @Override
    public PagedResponse<CashRegisterModel> getAll(PaginationRequest paginationRequest) {
        Pageable pageable = this.iMapperPaginationApp.toPageable(paginationRequest);
        Page<CashRegisterEntity> entityPage = this.iCashRegisterRepository.findAll(pageable);
        return this.iMapperPaginationApp.pagetoPagedResponse(
                entityPage,
                this.iMapperCashRegisterInfrastructure::toModel
        );
    }

    @Override
    public PagedResponse<CashRegisterModel> getByEmployeeId(UUID employeeId, PaginationRequest paginationRequest) {
        Pageable pageable = this.iMapperPaginationApp.toPageable(paginationRequest);
        Page<CashRegisterEntity> entityPage = this.iCashRegisterRepository.findByEmployee_Id(employeeId, pageable);
        return this.iMapperPaginationApp.pagetoPagedResponse(
                entityPage,
                this.iMapperCashRegisterInfrastructure::toModel
        );
    }
}
