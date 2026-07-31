package dev.juanleon.supermarket_inventory.cash_register.domain.useCases.post;

import dev.juanleon.supermarket_inventory.cash_register.domain.models.CashRegisterModel;
import dev.juanleon.supermarket_inventory.cash_register.domain.persistence.post.IPostCashRegisterPersistence;
import dev.juanleon.supermarket_inventory.cash_register.domain.ports.IPortEmployeeCashRegisterGet;
import dev.juanleon.supermarket_inventory.cash_register.domain.services.post.IPostCashRegisterService;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseModel;
import dev.juanleon.supermarket_inventory.employees.domain.models.EmployeeModel;

import java.util.UUID;

public class PostCashRegisterUseCase implements IPostCashRegisterService {

    private final IPostCashRegisterPersistence iPostCashRegisterPersistence;
    private final IPortEmployeeCashRegisterGet iPortEmployeeCashRegisterGet;

    public PostCashRegisterUseCase(IPostCashRegisterPersistence iPostCashRegisterPersistence, IPortEmployeeCashRegisterGet iPortEmployeeCashRegisterGet) {
        this.iPostCashRegisterPersistence = iPostCashRegisterPersistence;
        this.iPortEmployeeCashRegisterGet = iPortEmployeeCashRegisterGet;
    }

    @Override
    public ResponseModel create(CashRegisterModel cashRegisterModel, UUID employeeId) {
        EmployeeModel employeeModel = this.iPortEmployeeCashRegisterGet.getByIdForEmployee(employeeId);
        cashRegisterModel.setEmployee(employeeModel);
        String response = this.iPostCashRegisterPersistence.create(cashRegisterModel);
        return new ResponseModel(response);
    }
}
