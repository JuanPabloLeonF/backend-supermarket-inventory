package dev.juanleon.supermarket_inventory.modules.categories.infrastructure.outputs.providers;

import dev.juanleon.supermarket_inventory.modules.categories.domain.models.CategoriesModel;
import dev.juanleon.supermarket_inventory.modules.categories.infrastructure.outputs.database.mappers.IMapperCategoriesInfrastructure;
import dev.juanleon.supermarket_inventory.modules.categories.infrastructure.outputs.database.repositories.ICategoriesRepository;
import dev.juanleon.supermarket_inventory.modules.categories.infrastructure.outputs.exceptions.NotFoundCategoriesException;
import dev.juanleon.supermarket_inventory.modules.products.domain.ports.ICategoriesProviderProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ProductCategoriesProviderAdapter implements ICategoriesProviderProduct {

    private final ICategoriesRepository iCategoriesRepository;
    private final IMapperCategoriesInfrastructure iMapperCategoriesInfrastructure;

    @Override
    public CategoriesModel getCategoryById(UUID id) {
        return this.iCategoriesRepository.findById(id)
                .map(this.iMapperCategoriesInfrastructure::toModel)
                .orElseThrow(() -> new NotFoundCategoriesException(id));
    }
}
