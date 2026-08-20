package dev.juanleon.supermarket_inventory.modules.purchases.infrastructure.outputs.database.entities;

import dev.juanleon.supermarket_inventory.modules.products.infrastructure.outputs.database.entities.ProductEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "purchases_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PurchaseDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "purchases_id", nullable = false)
    private PurchaseEntity purchaseEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "products_id", nullable = false)
    private ProductEntity productEntity;

    @Column(nullable = false)
    private Integer quantity;

    @Column(name = "price_unit", nullable = false)
    private BigDecimal priceUnit;

    @Column(name = "sub_total", nullable = false)
    private BigDecimal subTotal;

    @Column(nullable = false)
    private BigDecimal iva;

    @Column(nullable = false)
    private BigDecimal discount;

    @Column(nullable = false)
    private BigDecimal total;

    @Override
    public String toString() {
        return "PurchaseDetailsEntity{" +
                "id=" + id +
                ", purchaseEntity=" + purchaseEntity +
                ", productEntity=" + productEntity +
                ", quantity=" + quantity +
                ", priceUnit=" + priceUnit +
                ", subTotal=" + subTotal +
                ", discount=" + discount +
                ", total=" + total +
                '}';
    }
}
