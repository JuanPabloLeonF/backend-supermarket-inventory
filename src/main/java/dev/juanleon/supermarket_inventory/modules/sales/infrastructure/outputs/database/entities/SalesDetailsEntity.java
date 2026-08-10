package dev.juanleon.supermarket_inventory.modules.sales.infrastructure.outputs.database.entities;

import dev.juanleon.supermarket_inventory.modules.products.infrastructure.outputs.database.entities.ProductEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "sales_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SalesDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sales_id", nullable = false)
    private SalesEntity salesEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private ProductEntity productEntity;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private BigDecimal priceUnit;

    @Column(nullable = false)
    private BigDecimal discount;

    @Column(nullable = false)
    private BigDecimal total;
}
