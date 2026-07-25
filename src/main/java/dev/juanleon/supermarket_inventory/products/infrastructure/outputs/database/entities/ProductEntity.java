package dev.juanleon.supermarket_inventory.products.infrastructure.outputs.database.entities;

import dev.juanleon.supermarket_inventory.categories.infrastructure.outputs.database.entities.CategoriesEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categories_id", nullable = false)
    private CategoriesEntity categoriesEntity;

    @Column(unique = true, nullable = false)
    private String code;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false, name = "unit_measurement")
    private String unitMeasurement;

    @Column(nullable = false, name = "price_sale")
    private BigDecimal priceSale;

    @Column(nullable = false, name = "price_purchase")
    private BigDecimal pricePurchase;

    @Column(nullable = false)
    private Integer stock;

    @Column(nullable = false)
    private Boolean active;

    @Column(name = "created_at", nullable = false)
    private LocalDate createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDate updatedAt;

    @Override
    public String toString() {
        return "ProductEntity{" +
                "id=" + id +
                ", categoriesEntity=" + categoriesEntity +
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
                '}';
    }
}
