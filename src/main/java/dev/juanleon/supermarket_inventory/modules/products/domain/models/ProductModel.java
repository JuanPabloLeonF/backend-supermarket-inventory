package dev.juanleon.supermarket_inventory.modules.products.domain.models;

import dev.juanleon.supermarket_inventory.modules.categories.domain.models.CategoriesModel;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class ProductModel {

    private UUID id;
    private CategoriesModel categoriesModel;
    private String code;
    private String name;
    private String description;
    private String unitMeasurement;
    private BigDecimal priceSale;
    private BigDecimal pricePurchase;
    private Integer stock;
    private Boolean active;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private String urlImg;

    private ProductModel(ProductsModelBuilder builder) {
        this.id = builder.id;
        this.categoriesModel = builder.categoriesModel;
        this.code = builder.code;
        this.name = builder.name;
        this.description = builder.description;
        this.unitMeasurement = builder.unitMeasurement;
        this.priceSale = builder.priceSale;
        this.pricePurchase = builder.pricePurchase;
        this.stock = builder.stock;
        this.active = builder.active;
        this.createdAt = builder.createdAt;
        this.updatedAt = builder.updatedAt;
        this.urlImg = builder.urlImg;
    }

    public static ProductsModelBuilder builder() {
        return new ProductsModelBuilder();
    }

    public static class ProductsModelBuilder {
        public UUID id;
        public CategoriesModel categoriesModel;
        public String code;
        public String name;
        public String description;
        public String unitMeasurement;
        public BigDecimal priceSale;
        public BigDecimal pricePurchase;
        public Integer stock;
        public Boolean active;
        public LocalDate createdAt;
        public LocalDate updatedAt;
        public String urlImg;

        public ProductsModelBuilder id(UUID id) {
            this.id = id;
            return this;
        }

        public ProductsModelBuilder categoriesModel(CategoriesModel categoriesModel) {
            this.categoriesModel = categoriesModel;
            return this;
        }

        public ProductsModelBuilder code(String code) {
            this.code = code;
            return this;
        }

        public ProductsModelBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ProductsModelBuilder description(String description) {
            this.description = description;
            return this;
        }

        public ProductsModelBuilder unitMeasurement(String unitMeasurement) {
            this.unitMeasurement = unitMeasurement;
            return this;
        }

        public ProductsModelBuilder priceSale(BigDecimal priceSale) {
            this.priceSale = priceSale;
            return this;
        }

        public ProductsModelBuilder pricePurchase(BigDecimal pricePurchase) {
            this.pricePurchase = pricePurchase;
            return this;
        }

        public ProductsModelBuilder stock(Integer stock) {
            this.stock = stock;
            return this;
        }

        public ProductsModelBuilder active(Boolean active) {
            this.active = active;
            return this;
        }

        public ProductsModelBuilder createdAt(LocalDate createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public ProductsModelBuilder updatedAt(LocalDate updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public ProductsModelBuilder urlImg(String urlImg) {
            this.urlImg = urlImg;
            return this;
        }

        public ProductModel build() {
            return new ProductModel(this);
        }
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public CategoriesModel getCategoriesModel() {
        return categoriesModel;
    }

    public void setCategoriesModel(CategoriesModel categoriesModel) {
        this.categoriesModel = categoriesModel;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnitMeasurement() {
        return unitMeasurement;
    }

    public void setUnitMeasurement(String unitMeasurement) {
        this.unitMeasurement = unitMeasurement;
    }

    public BigDecimal getPriceSale() {
        return priceSale;
    }

    public void setPriceSale(BigDecimal priceSale) {
        this.priceSale = priceSale;
    }

    public BigDecimal getPricePurchase() {
        return pricePurchase;
    }

    public void setPricePurchase(BigDecimal pricePurchase) {
        this.pricePurchase = pricePurchase;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    @Override
    public String toString() {
        return "ProductModel{" +
                "id=" + id +
                ", categoriesModel=" + categoriesModel +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", unitMeasurement='" + unitMeasurement + '\'' +
                ", priceSale=" + priceSale +
                ", pricePurchase=" + pricePurchase +
                ", stock=" + stock +
                ", active=" + active +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", urlImg=" + urlImg +
                '}';
    }
}
