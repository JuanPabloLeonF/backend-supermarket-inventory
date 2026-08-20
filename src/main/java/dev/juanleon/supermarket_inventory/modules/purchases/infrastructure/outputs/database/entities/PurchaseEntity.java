package dev.juanleon.supermarket_inventory.modules.purchases.infrastructure.outputs.database.entities;

import dev.juanleon.supermarket_inventory.modules.employees.infrastructure.outputs.database.entities.EmployeeEntity;
import dev.juanleon.supermarket_inventory.modules.providers.infrastructure.outputs.database.entities.ProviderEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "purchases")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PurchaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employees_id", nullable = false)
    private EmployeeEntity employeeEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "providers_id", nullable = false)
    private ProviderEntity providerEntity;

    @Column(name = "number_purchase", unique = true, nullable = false)
    private UUID numberPurchase;

    @Column(nullable = false)
    private BigDecimal iva;

    @Column(name = "sub_total", nullable = false)
    private BigDecimal subTotal;

    @Column(nullable = false)
    private BigDecimal total;

    @Column(nullable = false)
    private BigDecimal discount;

    @Column(name = "method_payment", nullable = false)
    private String methodPayment;

    @Column(nullable = false)
    private String observations;

    @Column(name = "date_purchase", nullable = false)
    private LocalDate datePurchase;

    @Column(name = "created_at", nullable = false)
    private LocalDate createdAt;

    @OneToMany(
            mappedBy = "purchaseEntity",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<PurchaseDetailsEntity> purchaseDetailsEntityList;

    @Override
    public String toString() {
        return "PurchaseEntity{" +
                "id=" + id +
                ", employeeEntity=" + employeeEntity +
                ", providerEntity=" + providerEntity +
                ", numberPurchase=" + numberPurchase +
                ", iva=" + iva +
                ", subTotal=" + subTotal +
                ", total=" + total +
                ", discount=" + discount +
                ", methodPayment='" + methodPayment + '\'' +
                ", observations='" + observations + '\'' +
                ", datePurchase=" + datePurchase +
                ", createdAt=" + createdAt +
                ", purchaseDetailsEntityList=" + purchaseDetailsEntityList +
                '}';
    }
}
