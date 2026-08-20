package dev.juanleon.supermarket_inventory.modules.purchases.domain.models;

import dev.juanleon.supermarket_inventory.modules.products.domain.models.ProductModel;

import java.math.BigDecimal;
import java.util.UUID;

public class PurchaseDetailsModel {

    private UUID id;
    private PurchaseModel purchaseModel;
    private ProductModel productModel;
    private Integer quantity;
    private BigDecimal priceUnit;
    private BigDecimal subTotal;
    private BigDecimal iva;
    private BigDecimal discount;
    private BigDecimal total;

    public PurchaseDetailsModel() {
    }

    public PurchaseDetailsModel(UUID id, PurchaseModel purchaseModel, ProductModel productModel, Integer quantity, BigDecimal priceUnit, BigDecimal subTotal, BigDecimal discount, BigDecimal iva, BigDecimal total) {
        this.id = id;
        this.purchaseModel = purchaseModel;
        this.productModel = productModel;
        this.quantity = quantity;
        this.priceUnit = priceUnit;
        this.subTotal = subTotal;
        this.discount = discount;
        this.iva = iva;
        this.total = total;
    }

    public BigDecimal getIva() {
        return iva;
    }

    public void setIva(BigDecimal iva) {
        this.iva = iva;
    }

    public PurchaseModel getPurchaseModel() {
        return purchaseModel;
    }

    public void setPurchaseModel(PurchaseModel purchaseModel) {
        this.purchaseModel = purchaseModel;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ProductModel getProductModel() {
        return productModel;
    }

    public void setProductModel(ProductModel productModel) {
        this.productModel = productModel;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPriceUnit() {
        return priceUnit;
    }

    public void setPriceUnit(BigDecimal priceUnit) {
        this.priceUnit = priceUnit;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "PurchaseDetailsModel{" +
                "id=" + id +
                ", purchaseModel=" + purchaseModel +
                ", productModel=" + productModel +
                ", quantity=" + quantity +
                ", priceUnit=" + priceUnit +
                ", subTotal=" + subTotal +
                ", iva=" + iva +
                ", discount=" + discount +
                ", total=" + total +
                '}';
    }
}
