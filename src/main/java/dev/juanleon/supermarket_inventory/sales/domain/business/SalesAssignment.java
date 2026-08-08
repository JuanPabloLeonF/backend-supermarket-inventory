package dev.juanleon.supermarket_inventory.sales.domain.business;

import dev.juanleon.supermarket_inventory.products.domain.models.ProductModel;
import dev.juanleon.supermarket_inventory.sales.domain.models.SalesModel;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

public final class SalesAssignment {

    private SalesAssignment(){}

    public static SalesModel salesAssignment(SalesModel sales, List<ProductModel> productModelList) {

        Map<UUID, ProductModel> productModelMap = listProductToMapProduct(productModelList);

        sales.getSalesDetailsModelList().forEach(salesDetailsModel -> {
            UUID id = salesDetailsModel.getProductModel().getId();
            ProductModel productFind = productModelMap.get(id);
            salesDetailsModel.setProductModel(productFind);
        });

        return sales;
    }

    public static List<UUID> getListIds(SalesModel sales) {
        return sales.getSalesDetailsModelList()
                .stream()
                .map(salesDetailsModel -> salesDetailsModel.getProductModel().getId())
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
