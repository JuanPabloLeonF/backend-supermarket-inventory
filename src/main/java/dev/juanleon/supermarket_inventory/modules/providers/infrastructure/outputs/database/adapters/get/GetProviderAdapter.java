package dev.juanleon.supermarket_inventory.modules.providers.infrastructure.outputs.database.adapters.get;

import dev.juanleon.supermarket_inventory.modules.providers.domain.models.ProviderModel;
import dev.juanleon.supermarket_inventory.modules.providers.domain.persistence.get.IGetProviderPersistence;
import dev.juanleon.supermarket_inventory.modules.providers.infrastructure.outputs.database.entities.ProviderEntity;
import dev.juanleon.supermarket_inventory.modules.providers.infrastructure.outputs.database.mappers.IMapperProviderInfrastructure;
import dev.juanleon.supermarket_inventory.modules.providers.infrastructure.outputs.database.repositories.IProviderRepository;
import dev.juanleon.supermarket_inventory.modules.providers.infrastructure.outputs.exceptions.NotFoundProviderException;
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
public class GetProviderAdapter implements IGetProviderPersistence {

    private final IProviderRepository iProviderRepository;
    private final IMapperProviderInfrastructure iMapperProviderInfrastructure;
    private final IMapperPaginationApp iMapperPaginationApp;

    @Override
    public ProviderModel getById(UUID id) {
        return this.iProviderRepository.findById(id)
                .map(this.iMapperProviderInfrastructure::toModel)
                .orElseThrow(() -> new NotFoundProviderException(id));
    }

    @Override
    public ProviderModel getByName(String name) {
        return this.iProviderRepository.findByFullName(name)
                .map(this.iMapperProviderInfrastructure::toModel)
                .orElseThrow(() -> new NotFoundProviderException(name));
    }

    @Override
    public PagedResponse<ProviderModel> getAll(PaginationRequest paginationRequest) {
        Pageable pageable = this.iMapperPaginationApp.toPageable(paginationRequest);
        Page<ProviderEntity> entityPage = this.iProviderRepository.findAll(pageable);
        return this.iMapperPaginationApp.pagetoPagedResponse(
                entityPage,
                this.iMapperProviderInfrastructure::toModel
        );
    }
}
