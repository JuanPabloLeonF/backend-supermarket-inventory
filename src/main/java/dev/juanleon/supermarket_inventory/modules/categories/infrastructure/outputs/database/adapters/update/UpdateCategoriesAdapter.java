package dev.juanleon.supermarket_inventory.modules.categories.infrastructure.outputs.database.adapters.update;

import dev.juanleon.supermarket_inventory.modules.categories.domain.models.CategoriesModel;
import dev.juanleon.supermarket_inventory.modules.categories.domain.persistence.update.IUpdateCategoriesPersistence;
import dev.juanleon.supermarket_inventory.modules.categories.infrastructure.outputs.database.repositories.ICategoriesRepository;
import dev.juanleon.supermarket_inventory.modules.categories.infrastructure.outputs.exceptions.NotFoundCategoriesException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static dev.juanleon.supermarket_inventory.share.utils.enums.MessagesApp.CATEGORIES_UPDATE_SUCCESSFULLY_BY_ID;

@Repository
@RequiredArgsConstructor
public class UpdateCategoriesAdapter implements IUpdateCategoriesPersistence {

    private final ICategoriesRepository iCategoriesRepository;

    @Override
    public String updateById(CategoriesModel categoriesModel) {
        return this.iCategoriesRepository.findById(categoriesModel.getId())
                .map(category -> {
                    category.setName(categoriesModel.getName());
                    category.setDescription(categoriesModel.getDescription());
                    this.iCategoriesRepository.save(category);
                    return CATEGORIES_UPDATE_SUCCESSFULLY_BY_ID.format(category.getId());
                }).orElseThrow(() -> new NotFoundCategoriesException(categoriesModel.getId()));
    }
}
