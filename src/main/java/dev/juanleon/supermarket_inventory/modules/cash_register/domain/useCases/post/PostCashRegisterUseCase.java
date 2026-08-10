package dev.juanleon.supermarket_inventory.modules.cash_register.domain.useCases.post;

import dev.juanleon.supermarket_inventory.modules.cash_register.domain.models.CashRegisterModel;
import dev.juanleon.supermarket_inventory.modules.cash_register.domain.persistence.post.IPostCashRegisterPersistence;
import dev.juanleon.supermarket_inventory.modules.cash_register.domain.ports.IEmployeeProviderCashRegister;
import dev.juanleon.supermarket_inventory.modules.cash_register.domain.services.post.IPostCashRegisterService;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.modules.employees.domain.models.EmployeeModel;

import java.util.UUID;

public class PostCashRegisterUseCase implements IPostCashRegisterService {

    private final IPostCashRegisterPersistence iPostCashRegisterPersistence;
    private final IEmployeeProviderCashRegister iEmployeeProviderCashRegister;

    public PostCashRegisterUseCase(IPostCashRegisterPersistence iPostCashRegisterPersistence, IEmployeeProviderCashRegister iEmployeeProviderCashRegister) {
        this.iPostCashRegisterPersistence = iPostCashRegisterPersistence;
        this.iEmployeeProviderCashRegister = iEmployeeProviderCashRegister;
    }

    @Override
    public ResponseModel create(CashRegisterModel cashRegisterModel, UUID employeeId) {
        EmployeeModel employeeModel = this.iEmployeeProviderCashRegister.getEmployeeById(employeeId);
        cashRegisterModel.setEmployee(employeeModel);
        String response = this.iPostCashRegisterPersistence.create(cashRegisterModel);
        return new ResponseModel(response);
    }
}
