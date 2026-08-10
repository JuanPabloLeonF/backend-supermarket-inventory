package dev.juanleon.supermarket_inventory.modules.cash_register.domain.useCases.delete;

import dev.juanleon.supermarket_inventory.modules.cash_register.domain.persistence.delete.IDeleteCashRegisterPersistence;
import dev.juanleon.supermarket_inventory.modules.cash_register.domain.services.delete.IDeleteCashRegisterService;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseModel;

import java.util.UUID;

public class DeleteCashRegisterUseCase implements IDeleteCashRegisterService {

    private final IDeleteCashRegisterPersistence iDeleteCashRegisterPersistence;

    public DeleteCashRegisterUseCase(IDeleteCashRegisterPersistence iDeleteCashRegisterPersistence) {
        this.iDeleteCashRegisterPersistence = iDeleteCashRegisterPersistence;
    }

    @Override
    public ResponseModel deleteById(UUID id) {
        String response = this.iDeleteCashRegisterPersistence.deleteById(id);
        return new ResponseModel(response);
    }
}
