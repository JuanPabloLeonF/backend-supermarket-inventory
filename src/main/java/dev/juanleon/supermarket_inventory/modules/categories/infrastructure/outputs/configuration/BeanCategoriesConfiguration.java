package dev.juanleon.supermarket_inventory.modules.categories.infrastructure.outputs.configuration;

import dev.juanleon.supermarket_inventory.modules.categories.domain.persistence.delete.IDeleteCategoriesPersistence;
import dev.juanleon.supermarket_inventory.modules.categories.domain.persistence.get.IGetCategoriesPersistence;
import dev.juanleon.supermarket_inventory.modules.categories.domain.persistence.post.IPostCategoriesPersistence;
import dev.juanleon.supermarket_inventory.modules.categories.domain.persistence.update.IUpdateCategoriesPersistence;
import dev.juanleon.supermarket_inventory.modules.categories.domain.services.delete.IDeleteCategoriesServices;
import dev.juanleon.supermarket_inventory.modules.categories.domain.services.get.IGetCategoriesServices;
import dev.juanleon.supermarket_inventory.modules.categories.domain.services.post.IPostCategoriesServices;
import dev.juanleon.supermarket_inventory.modules.categories.domain.services.update.IUpdateCategoriesServices;
import dev.juanleon.supermarket_inventory.modules.categories.domain.useCases.delete.DeleteCategoriesUseCases;
import dev.juanleon.supermarket_inventory.modules.categories.domain.useCases.get.GetCategoriesUseCases;
import dev.juanleon.supermarket_inventory.modules.categories.domain.useCases.post.PostCategoriesUseCases;
import dev.juanleon.supermarket_inventory.modules.categories.domain.useCases.update.UpdateCategoriesUseCases;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanCategoriesConfiguration {

    @Bean
    public IGetCategoriesServices iGetCategoriesServices(IGetCategoriesPersistence iGetCategoriesPersistence) {
        return new GetCategoriesUseCases(iGetCategoriesPersistence);
    }

    @Bean
    public IPostCategoriesServices iPostCategoriesServices(IPostCategoriesPersistence iPostCategoriesPersistence) {
        return new PostCategoriesUseCases(iPostCategoriesPersistence);
    }

    @Bean
    public IUpdateCategoriesServices iUpdateCategoriesServices(IUpdateCategoriesPersistence iUpdateCategoriesPersistence) {
        return new UpdateCategoriesUseCases(iUpdateCategoriesPersistence);
    }

    @Bean
    public IDeleteCategoriesServices iDeleteCategoriesServices(IDeleteCategoriesPersistence iDeleteCategoriesPersistence) {
        return new DeleteCategoriesUseCases(iDeleteCategoriesPersistence);
    }
}
