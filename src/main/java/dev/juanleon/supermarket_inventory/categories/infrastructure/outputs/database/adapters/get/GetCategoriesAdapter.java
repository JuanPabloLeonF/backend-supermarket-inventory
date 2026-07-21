package dev.juanleon.supermarket_inventory.categories.infrastructure.outputs.database.adapters.get;

import dev.juanleon.supermarket_inventory.categories.domain.models.CategoriesModel;
import dev.juanleon.supermarket_inventory.categories.domain.persistence.get.IGetCategoriesPersistence;
import dev.juanleon.supermarket_inventory.categories.infrastructure.outputs.database.entities.CategoriesEntity;
import dev.juanleon.supermarket_inventory.categories.infrastructure.outputs.database.mappers.IMapperCategoriesInfrastructure;
import dev.juanleon.supermarket_inventory.categories.infrastructure.outputs.database.repositories.ICategoriesRepository;
import dev.juanleon.supermarket_inventory.categories.infrastructure.outputs.exceptions.NotFoundCategoriesException;
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
public class GetCategoriesAdapter implements IGetCategoriesPersistence {

    private final ICategoriesRepository iCategoriesRepository;
    private final IMapperPaginationApp iMapperPaginationApp;
    private final IMapperCategoriesInfrastructure iMapperCategoriesInfrastructure;

    @Override
    public CategoriesModel getById(UUID id) {
        return this.iCategoriesRepository.findById(id)
                .map(this.iMapperCategoriesInfrastructure::toModel)
                .orElseThrow(() -> new NotFoundCategoriesException(id));
    }

    @Override
    public PagedResponse<CategoriesModel> getAll(PaginationRequest paginationRequest) {
        Pageable pageable = this.iMapperPaginationApp.toPageable(paginationRequest);
        Page<CategoriesEntity> entityPage = this.iCategoriesRepository.findAll(pageable);
        return this.iMapperPaginationApp.pagetoPagedResponse(entityPage, this.iMapperCategoriesInfrastructure::toModel);
    }

    @Override
    public PagedResponse<CategoriesModel> getByName(PaginationRequest paginationRequest, String name) {
        Pageable pageable = this.iMapperPaginationApp.toPageable(paginationRequest);
        Page<CategoriesEntity> entityPage = this.iCategoriesRepository.findByName(name, pageable);
        return this.iMapperPaginationApp.pagetoPagedResponse(entityPage, this.iMapperCategoriesInfrastructure::toModel);
    }
}
