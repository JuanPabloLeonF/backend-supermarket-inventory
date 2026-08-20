package dev.juanleon.supermarket_inventory.modules.purchases.domain.services.get;

import dev.juanleon.supermarket_inventory.modules.purchases.domain.models.PurchaseModel;
import dev.juanleon.supermarket_inventory.share.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.share.utils.dto.PaginationRequest;

import java.util.UUID;

public interface IGetPurchaseService {
    PurchaseModel getById(UUID id);
    PagedResponse<PurchaseModel> getAll(PaginationRequest paginationRequest);
    PagedResponse<PurchaseModel> getAllByIdProvider(UUID idProvider, PaginationRequest paginationRequest);
    PagedResponse<PurchaseModel> getAllByIdEmployee(UUID idEmployee, PaginationRequest paginationRequest);
}
