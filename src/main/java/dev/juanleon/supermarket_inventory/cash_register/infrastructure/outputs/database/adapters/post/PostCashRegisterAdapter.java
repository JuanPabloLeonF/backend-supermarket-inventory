package dev.juanleon.supermarket_inventory.cash_register.infrastructure.outputs.database.adapters.post;

import dev.juanleon.supermarket_inventory.cash_register.domain.models.CashRegisterModel;
import dev.juanleon.supermarket_inventory.cash_register.domain.persistence.post.IPostCashRegisterPersistence;
import dev.juanleon.supermarket_inventory.cash_register.infrastructure.outputs.database.entities.CashRegisterEntity;
import dev.juanleon.supermarket_inventory.cash_register.infrastructure.outputs.database.mappers.IMapperCashRegisterInfrastructure;
import dev.juanleon.supermarket_inventory.cash_register.infrastructure.outputs.database.repositories.ICashRegisterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

import static dev.juanleon.supermarket_inventory.common.utils.enums.MessagesApp.CASH_REGISTER_CREATED_SUCCESSFULLY;

@Repository
@RequiredArgsConstructor
public class PostCashRegisterAdapter implements IPostCashRegisterPersistence {

    private final ICashRegisterRepository iCashRegisterRepository;
    private final IMapperCashRegisterInfrastructure iMapperCashRegisterInfrastructure;

    @Override
    public String create(CashRegisterModel cashRegisterModel) {
        CashRegisterEntity entity = this.iMapperCashRegisterInfrastructure.toEntity(cashRegisterModel);
        UUID id = this.iCashRegisterRepository.save(entity).getId();
        return CASH_REGISTER_CREATED_SUCCESSFULLY.format(id);
    }
}
