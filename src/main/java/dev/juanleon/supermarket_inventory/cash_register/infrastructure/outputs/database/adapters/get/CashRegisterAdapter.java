package dev.juanleon.supermarket_inventory.cash_register.infrastructure.outputs.database.adapters.get;

import dev.juanleon.supermarket_inventory.cash_register.domain.models.CashRegisterModel;
import dev.juanleon.supermarket_inventory.cash_register.domain.persistence.get.IGetCashRegisterPersistence;
import dev.juanleon.supermarket_inventory.cash_register.infrastructure.outputs.database.mappers.IMapperCashRegisterInfrastructure;
import dev.juanleon.supermarket_inventory.cash_register.infrastructure.outputs.database.repositories.ICashRegisterRepository;
import dev.juanleon.supermarket_inventory.common.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.common.utils.dto.PaginationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class CashRegisterAdapter implements IGetCashRegisterPersistence {

    private final ICashRegisterRepository iCashRegisterRepository;
    private final IMapperCashRegisterInfrastructure iMapperCashRegisterInfrastructure;

    @Override
    public CashRegisterModel getById(UUID id) {
        return this.iCashRegisterRepository.findById(id)
                .map(iMapperCashRegisterInfrastructure::toModel)
                .orElseThrow(() -> new RuntimeException("Cash register not found"));
    }

    @Override
    public PagedResponse<CashRegisterModel> getAll(PaginationRequest paginationRequest) {
        return null;
    }

    @Override
    public PagedResponse<CashRegisterModel> getByEmployeeId(UUID employeeId, PaginationRequest paginationRequest) {
        return null;
    }
}
