package dev.juanleon.supermarket_inventory.sales.infrastructure.outputs.database.adapters.post;

import dev.juanleon.supermarket_inventory.sales.domain.models.SalesModel;
import dev.juanleon.supermarket_inventory.sales.domain.persistence.post.IPostSalesPersistence;
import dev.juanleon.supermarket_inventory.sales.infrastructure.outputs.database.entities.SalesEntity;
import dev.juanleon.supermarket_inventory.sales.infrastructure.outputs.database.mappers.IMapperSalesInfrastructure;
import dev.juanleon.supermarket_inventory.sales.infrastructure.outputs.database.repositories.ISalesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

import static dev.juanleon.supermarket_inventory.common.utils.enums.MessagesApp.SALES_CREATED_SUCCESSFULLY;

@Repository
@RequiredArgsConstructor
public class PostSalesAdapter implements IPostSalesPersistence {

    private final ISalesRepository iSalesRepository;
    private final IMapperSalesInfrastructure iMapperSalesInfrastructure;

    @Override
    public String create(SalesModel salesModel) {
        SalesEntity entity = this.iMapperSalesInfrastructure.toEntity(salesModel);
        UUID id =this.iSalesRepository.save(entity).getId();
        return SALES_CREATED_SUCCESSFULLY.format(id);
    }
}
