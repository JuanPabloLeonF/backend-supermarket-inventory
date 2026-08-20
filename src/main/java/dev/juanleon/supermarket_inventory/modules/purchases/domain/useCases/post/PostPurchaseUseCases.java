package dev.juanleon.supermarket_inventory.modules.purchases.domain.useCases.post;

import dev.juanleon.supermarket_inventory.modules.employees.domain.models.EmployeeModel;
import dev.juanleon.supermarket_inventory.modules.products.domain.models.ProductModel;
import dev.juanleon.supermarket_inventory.modules.providers.domain.models.ProviderModel;
import dev.juanleon.supermarket_inventory.modules.purchases.domain.business.PurchaseAssignment;
import dev.juanleon.supermarket_inventory.modules.purchases.domain.business.PurchaseCalculator;
import dev.juanleon.supermarket_inventory.modules.purchases.domain.models.PostDataBusinessPurchase;
import dev.juanleon.supermarket_inventory.modules.purchases.domain.models.PurchaseModel;
import dev.juanleon.supermarket_inventory.modules.purchases.domain.persistence.post.IPostPurchasePersistence;
import dev.juanleon.supermarket_inventory.modules.purchases.domain.ports.IEmployeeProviderPurchase;
import dev.juanleon.supermarket_inventory.modules.purchases.domain.ports.IProductProviderPurchase;
import dev.juanleon.supermarket_inventory.modules.purchases.domain.ports.IProviderProviderPurchase;
import dev.juanleon.supermarket_inventory.modules.purchases.domain.services.post.IPostPurchaseService;
import dev.juanleon.supermarket_inventory.share.utils.dto.ResponseModel;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class PostPurchaseUseCases implements IPostPurchaseService {

    private final IPostPurchasePersistence iPostPurchasePersistence;
    private final IEmployeeProviderPurchase iEmployeeProviderPurchase;
    private final IProviderProviderPurchase iProviderProviderPurchase;
    private final IProductProviderPurchase iProductProviderPurchase;

    public PostPurchaseUseCases(IPostPurchasePersistence iPostPurchasePersistence, IEmployeeProviderPurchase iEmployeeProviderPurchase, IProviderProviderPurchase iProviderProviderPurchase, IProductProviderPurchase iProductProviderPurchase) {
        this.iPostPurchasePersistence = iPostPurchasePersistence;
        this.iEmployeeProviderPurchase = iEmployeeProviderPurchase;
        this.iProviderProviderPurchase = iProviderProviderPurchase;
        this.iProductProviderPurchase = iProductProviderPurchase;
    }

    @Override
    public ResponseModel create(PurchaseModel purchaseModel) {

        EmployeeModel employeeFound = this.iEmployeeProviderPurchase.getEmployeeById(purchaseModel.getEmployeeModel().getId());
        purchaseModel.setEmployeeModel(employeeFound);

        ProviderModel providerFound = this.iProviderProviderPurchase.getProviderById(purchaseModel.getProviderModel().getId());
        purchaseModel.setProviderModel(providerFound);

        List<UUID> productIds = PurchaseAssignment.getListIds(purchaseModel);

        List<ProductModel> productsModelList = this.iProductProviderPurchase.getProductsByIds(productIds);

        PurchaseModel purchaseAssignment = PurchaseAssignment.purchaseAssignment(purchaseModel, productsModelList);

        PostDataBusinessPurchase postDataBusinessPurchase = PurchaseCalculator.calculateAllPurchases(purchaseAssignment);

        PurchaseModel purchaseCalculated = postDataBusinessPurchase.purchaseModel();
        Map<UUID, Integer> newStockMap = postDataBusinessPurchase.newStockMap();

        purchaseCalculated.setNumberPurchase(UUID.randomUUID());
        purchaseCalculated.setDatePurchase(LocalDate.now());
        purchaseCalculated.setCreatedAt(LocalDate.now());

        String response = this.iPostPurchasePersistence.create(purchaseCalculated);

        this.iProductProviderPurchase.updateStockProductsByIds(newStockMap, productsModelList);

        return new ResponseModel(response);
    }
}
