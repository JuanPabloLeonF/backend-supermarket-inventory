package dev.juanleon.supermarket_inventory.categories.infrastructure.outputs.database.adapters.delete;

import dev.juanleon.supermarket_inventory.categories.domain.persistence.delete.IDeleteCategoriesPersistence;
import dev.juanleon.supermarket_inventory.categories.infrastructure.outputs.database.repositories.ICategoriesRepository;
import dev.juanleon.supermarket_inventory.categories.infrastructure.outputs.exceptions.NotFoundCategoriesException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

import static dev.juanleon.supermarket_inventory.common.utils.enums.MessagesApp.CATEGORIES_DELETED_SUCCESSFULLY_BY_ID;

@Repository
@RequiredArgsConstructor
public class DeleteCategoriesAdapter implements IDeleteCategoriesPersistence {

    private final ICategoriesRepository iCategoriesRepository;

    @Override
    public String deleteById(UUID id) {
        return this.iCategoriesRepository.findById(id)
                .map(category -> {
                    this.iCategoriesRepository.deleteById(category.getId());
                    return CATEGORIES_DELETED_SUCCESSFULLY_BY_ID.format(category.getId());
                }).orElseThrow(() -> new NotFoundCategoriesException(id));
    }
}
