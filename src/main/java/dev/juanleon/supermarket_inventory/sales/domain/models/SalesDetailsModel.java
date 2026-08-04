package dev.juanleon.supermarket_inventory.sales.domain.models;

import dev.juanleon.supermarket_inventory.products.domain.models.ProductModel;

import java.math.BigDecimal;
import java.util.UUID;

public class SalesDetailsModel {

    private UUID id;
    private SalesModel salesModel;
    private ProductModel productModel;
    private Integer quantity;
    private BigDecimal priceUnit;
    private BigDecimal discount;
    private BigDecimal total;

    private SalesDetailsModel(SalesDetailsModelBuilder builder) {
        this.id = builder.id;
        this.salesModel = builder.salesModel;
        this.productModel = builder.productModel;
        this.quantity = builder.quantity;
        this.priceUnit = builder.priceUnit;
        this.discount = builder.discount;
        this.total = builder.total;
    }

    public static SalesDetailsModelBuilder builder() {
        return new SalesDetailsModelBuilder();
    }

    public static class SalesDetailsModelBuilder {

        private UUID id;
        private SalesModel salesModel;
        private ProductModel productModel;
        private Integer quantity;
        private BigDecimal priceUnit;
        private BigDecimal discount;
        private BigDecimal total;

        public SalesDetailsModelBuilder id(UUID id) {
            this.id = id;
            return this;
        }

        public SalesDetailsModelBuilder salesModel(SalesModel salesModel) {
            this.salesModel = salesModel;
            return this;
        }

        public SalesDetailsModelBuilder productModel(ProductModel productModel) {
            this.productModel = productModel;
            return this;
        }

        public SalesDetailsModelBuilder quantity(Integer quantity) {
            this.quantity = quantity;
            return this;
        }

        public SalesDetailsModelBuilder priceUnit(BigDecimal priceUnit) {
            this.priceUnit = priceUnit;
            return this;
        }

        public SalesDetailsModelBuilder discount(BigDecimal discount) {
            this.discount = discount;
            return this;
        }

        public SalesDetailsModelBuilder total(BigDecimal total) {
            this.total = total;
            return this;
        }

        public SalesDetailsModel build() {
            return new SalesDetailsModel(this);
        }
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
                ", total=" + total +
                '}';
    }
}