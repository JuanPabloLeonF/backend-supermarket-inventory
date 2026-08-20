package dev.juanleon.supermarket_inventory.modules.purchases.infrastructure.outputs.database.adapters.get;

import dev.juanleon.supermarket_inventory.modules.purchases.domain.models.PurchaseModel;
import dev.juanleon.supermarket_inventory.modules.purchases.domain.persistence.get.IGetPurchasePersistence;
import dev.juanleon.supermarket_inventory.modules.purchases.infrastructure.outputs.database.entities.PurchaseEntity;
import dev.juanleon.supermarket_inventory.modules.purchases.infrastructure.outputs.database.mappers.IMapperPurchaseInfrastructure;
import dev.juanleon.supermarket_inventory.modules.purchases.infrastructure.outputs.database.repositories.IPurchaseRepository;
import dev.juanleon.supermarket_inventory.modules.purchases.infrastructure.outputs.exceptions.NotFoundPurchaseException;
import dev.juanleon.supermarket_inventory.share.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.share.utils.dto.PaginationRequest;
import dev.juanleon.supermarket_inventory.share.utils.mappers.IMapperPaginationApp;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class GetPurchaseAdapter implements IGetPurchasePersistence {

    private final IPurchaseRepository iPurchaseRepository;
    private final IMapperPaginationApp iMapperPaginationApp;
    private final IMapperPurchaseInfrastructure iMapperPurchaseInfrastructure;

    @Override
    public PurchaseModel getById(UUID id) {
        return this.iPurchaseRepository.findById(id)
                .map(this.iMapperPurchaseInfrastructure::toModel)
                .orElseThrow(() -> new NotFoundPurchaseException(id));
    }

    @Override
    public PagedResponse<PurchaseModel> getAll(PaginationRequest paginationRequest) {
        Pageable pageable = this.iMapperPaginationApp.toPageable(paginationRequest);
        Page<PurchaseEntity> entityPage = this.iPurchaseRepository.findAll(pageable);
        return this.iMapperPaginationApp.pagetoPagedResponse(
                entityPage,
                this.iMapperPurchaseInfrastructure::toModel
        );
    }

    @Override
    public PagedResponse<PurchaseModel> getAllByIdProvider(UUID idProvider, PaginationRequest paginationRequest) {
        Pageable pageable = this.iMapperPaginationApp.toPageable(paginationRequest);
        Page<PurchaseEntity> entityPage = this.iPurchaseRepository.findByProviderEntity_Id(idProvider, pageable);
        return this.iMapperPaginationApp.pagetoPagedResponse(
                entityPage,
                this.iMapperPurchaseInfrastructure::toModel
        );
    }

    @Override
    public PagedResponse<PurchaseModel> getAllByIdEmployee(UUID idEmployee, PaginationRequest paginationRequest) {
        Pageable pageable = this.iMapperPaginationApp.toPageable(paginationRequest);
        Page<PurchaseEntity> entityPage = this.iPurchaseRepository.findByEmployeeEntity_Id(idEmployee, pageable);
        return this.iMapperPaginationApp.pagetoPagedResponse(
                entityPage,
                this.iMapperPurchaseInfrastructure::toModel
        );
    }
}
