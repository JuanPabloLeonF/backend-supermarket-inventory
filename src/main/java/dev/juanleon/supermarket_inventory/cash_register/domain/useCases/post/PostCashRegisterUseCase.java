package dev.juanleon.supermarket_inventory.cash_register.domain.useCases.post;

import dev.juanleon.supermarket_inventory.cash_register.domain.models.CashRegisterModel;
import dev.juanleon.supermarket_inventory.cash_register.domain.persistence.post.IPostCashRegisterPersistence;
import dev.juanleon.supermarket_inventory.cash_register.domain.services.post.IPostCashRegisterService;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.employees.domain.services.get.IGetEmployeeService;

public class PostCashRegisterUseCase implements IPostCashRegisterService {

    private final IPostCashRegisterPersistence iPostCashRegisterPersistence;
    private final IGetEmployeeService iGetEmployeeService;

    public PostCashRegisterUseCase(IPostCashRegisterPersistence iPostCashRegisterPersistence, IGetEmployeeService iGetEmployeeService) {
        this.iPostCashRegisterPersistence = iPostCashRegisterPersistence;
        this.iGetEmployeeService = iGetEmployeeService;
    }

    @Override
    public ResponseModel create(CashRegisterModel cashRegisterModel) {
        this.iGetEmployeeService.getById(cashRegisterModel.getEmployee().getId());
        String response = this.iPostCashRegisterPersistence.create(cashRegisterModel);
        return new ResponseModel(response);
    }
}
