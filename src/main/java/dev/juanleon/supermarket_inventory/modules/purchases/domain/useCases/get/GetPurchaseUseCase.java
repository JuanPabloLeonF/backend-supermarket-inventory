package dev.juanleon.supermarket_inventory.modules.purchases.domain.useCases.get;

import dev.juanleon.supermarket_inventory.modules.purchases.domain.models.PurchaseModel;
import dev.juanleon.supermarket_inventory.modules.purchases.domain.persistence.get.IGetPurchasePersistence;
import dev.juanleon.supermarket_inventory.modules.purchases.domain.ports.IEmployeeProviderPurchase;
import dev.juanleon.supermarket_inventory.modules.purchases.domain.ports.IProviderProviderPurchase;
import dev.juanleon.supermarket_inventory.modules.purchases.domain.services.get.IGetPurchaseService;
import dev.juanleon.supermarket_inventory.share.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.share.utils.dto.PaginationRequest;

import java.util.UUID;

public class GetPurchaseUseCase implements IGetPurchaseService {

    private final IGetPurchasePersistence iGetPurchasePersistence;
    private final IProviderProviderPurchase iProviderProviderPurchase;
    private final IEmployeeProviderPurchase iEmployeeProviderPurchase;

    public GetPurchaseUseCase(IGetPurchasePersistence iGetPurchasePersistence, IProviderProviderPurchase iProviderProviderPurchase, IEmployeeProviderPurchase iEmployeeProviderPurchase) {
        this.iGetPurchasePersistence = iGetPurchasePersistence;
        this.iProviderProviderPurchase = iProviderProviderPurchase;
        this.iEmployeeProviderPurchase = iEmployeeProviderPurchase;
    }

    @Override
    public PurchaseModel getById(UUID id) {
        return this.iGetPurchasePersistence.getById(id);
    }

    @Override
    public PagedResponse<PurchaseModel> getAll(PaginationRequest paginationRequest) {
        return this.iGetPurchasePersistence.getAll(paginationRequest);
    }

    @Override
    public PagedResponse<PurchaseModel> getAllByIdProvider(UUID idProvider, PaginationRequest paginationRequest) {
        this.iProviderProviderPurchase.getProviderById(idProvider);
        return this.iGetPurchasePersistence.getAllByIdProvider(idProvider, paginationRequest);
    }

    @Override
    public PagedResponse<PurchaseModel> getAllByIdEmployee(UUID idEmployee, PaginationRequest paginationRequest) {
        this.iEmployeeProviderPurchase.getEmployeeById(idEmployee);
        return this.iGetPurchasePersistence.getAllByIdEmployee(idEmployee, paginationRequest);
    }
}
