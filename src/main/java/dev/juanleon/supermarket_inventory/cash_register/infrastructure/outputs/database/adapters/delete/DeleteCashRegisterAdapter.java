package dev.juanleon.supermarket_inventory.cash_register.infrastructure.outputs.database.adapters.delete;

import dev.juanleon.supermarket_inventory.cash_register.domain.persistence.delete.IDeleteCashRegisterPersistence;
import dev.juanleon.supermarket_inventory.cash_register.infrastructure.outputs.database.repositories.ICashRegisterRepository;
import dev.juanleon.supermarket_inventory.cash_register.infrastructure.outputs.exceptions.NotFoundCashRegisterException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

import static dev.juanleon.supermarket_inventory.common.utils.enums.MessagesApp.CASH_REGISTER_DELETED_SUCCESSFULLY_BY_ID;

@Repository
@RequiredArgsConstructor
public class DeleteCashRegisterAdapter implements IDeleteCashRegisterPersistence {

    private final ICashRegisterRepository iCashRegisterRepository;

    @Override
    public String deleteById(UUID id) {
        return this.iCashRegisterRepository.findById(id)
                .map(entity -> {
                    this.iCashRegisterRepository.deleteById(entity.getId());
                    return CASH_REGISTER_DELETED_SUCCESSFULLY_BY_ID.format(entity.getId());
                }).orElseThrow(() -> new NotFoundCashRegisterException(id));
    }
}
