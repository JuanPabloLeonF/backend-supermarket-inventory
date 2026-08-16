package dev.juanleon.supermarket_inventory.modules.purchases.domain.business;

import dev.juanleon.supermarket_inventory.modules.products.domain.models.ProductModel;
import dev.juanleon.supermarket_inventory.modules.purchases.domain.models.PurchaseModel;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

public final class PurchaseAssignment {

    private PurchaseAssignment() {}

    public static PurchaseModel purchaseAssignment(PurchaseModel purchase, List<ProductModel> productModelList) {

        Map<UUID, ProductModel> productModelMap = listProductToMapProduct(productModelList);

        purchase.getPurchaseDetailModelList().forEach(purchaseDetailModel -> {
            UUID id = purchaseDetailModel.getProductModel().getId();
            ProductModel productFind = productModelMap.get(id);
            purchaseDetailModel.setProductModel(productFind);
            purchaseDetailModel.setPriceUnit(productFind.getPricePurchase());
            purchaseDetailModel.setPurchaseModel(purchase);
        });

        return purchase;
    }

    public static List<UUID> getListIds(PurchaseModel purchase) {
        return purchase.getPurchaseDetailModelList()
                .stream()
                .map(purchaseDetailModel -> purchaseDetailModel.getProductModel().getId())
                .collect(Collectors.toList());
    }

    public static Map<UUID, ProductModel> listProductToMapProduct(List<ProductModel> productModelList) {
        return productModelList.stream()
                .collect(Collectors.toMap(
                        ProductModel::getId,
                        productModel -> productModel
                ));
    }
}
