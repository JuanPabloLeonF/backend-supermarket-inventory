package dev.juanleon.supermarket_inventory.categories.infrastructure.outputs.database.adapters.post;

import dev.juanleon.supermarket_inventory.categories.domain.models.CategoriesModel;
import dev.juanleon.supermarket_inventory.categories.domain.persistence.post.IPostCategoriesPersistence;
import dev.juanleon.supermarket_inventory.categories.infrastructure.outputs.database.entities.CategoriesEntity;
import dev.juanleon.supermarket_inventory.categories.infrastructure.outputs.database.mappers.IMapperCategoriesInfrastructure;
import dev.juanleon.supermarket_inventory.categories.infrastructure.outputs.database.repositories.ICategoriesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

import static dev.juanleon.supermarket_inventory.common.utils.enums.MessagesApp.CATEGORIES_CREATED_SUCCESSFULLY;

@Repository
@RequiredArgsConstructor
public class PostCategoriesAdapter implements IPostCategoriesPersistence {

    private final ICategoriesRepository iCategoriesRepository;
    private final IMapperCategoriesInfrastructure iMapperCategoriesInfrastructure;

    @Override
    public String create(CategoriesModel categoriesModel) {
        CategoriesEntity entity = this.iMapperCategoriesInfrastructure.toEntity(categoriesModel);
        UUID id = this.iCategoriesRepository.save(entity).getId();
        return CATEGORIES_CREATED_SUCCESSFULLY.format(id);
    }
}
