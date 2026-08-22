package dev.juanleon.supermarket_inventory.modules.sales.domain.models;

import dev.juanleon.supermarket_inventory.modules.products.domain.models.ProductModel;

import java.math.BigDecimal;
import java.util.UUID;

public class SalesDetailsModel {

    private UUID id;
    private SalesModel salesModel;
    private ProductModel productModel;
    private Integer quantity;
    private BigDecimal priceUnit;
    private BigDecimal discount;
    private BigDecimal subTotal;
    private BigDecimal iva;
    private BigDecimal total;

    public SalesDetailsModel() {
    }

    public SalesDetailsModel(UUID id, SalesModel salesModel, ProductModel productModel, Integer quantity, BigDecimal priceUnit, BigDecimal discount, BigDecimal subTotal, BigDecimal iva, BigDecimal total) {
        this.id = id;
        this.salesModel = salesModel;
        this.productModel = productModel;
        this.quantity = quantity;
        this.priceUnit = priceUnit;
        this.discount = discount;
        this.subTotal = subTotal;
        this.iva = iva;
        this.total = total;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public SalesModel getSalesModel() {
        return salesModel;
    }

    public void setSalesModel(SalesModel salesModel) {
        this.salesModel = salesModel;
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

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getIva() {
        return iva;
    }

    public void setIva(BigDecimal iva) {
        this.iva = iva;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "SalesDetailsModel{" +
                "id=" + id +
                ", salesModel=" + salesModel +
                ", productModel=" + productModel +
                ", quantity=" + quantity +
                ", priceUnit=" + priceUnit +
                ", discount=" + discount +
                ", subTotal=" + subTotal +
                ", iva=" + iva +
                ", total=" + total +
                '}';
    }
}