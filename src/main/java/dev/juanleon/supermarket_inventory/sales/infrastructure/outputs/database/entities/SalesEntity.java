package dev.juanleon.supermarket_inventory.sales.infrastructure.outputs.database.entities;

import dev.juanleon.supermarket_inventory.employees.infrastructure.outputs.database.entities.EmployeeEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "sales")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SalesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", nullable = false, referencedColumnName = "id")
    private EmployeeEntity employee;
    @Column(name = "number_sale", unique = true, nullable = false)
    private UUID numberSale;
    @Column(name = "date_sale", nullable = false)
    private LocalDateTime dateSale;
    @Column(name = "sub_total", nullable = false)
    private BigDecimal subTotal;
    @Column(nullable = false)
    private BigDecimal discount;
    @Column(nullable = false)
    private BigDecimal iva;
    @Column(nullable = false)
    private BigDecimal total;
    @Column(name = "method_payment", nullable = false)
    private String methodPayment;
    @Column(nullable = false)
    private String status;

    @Override
    public String toString() {
        return "SalesEntity{" +
                "id=" + id +
                ", employee=" + employee +
                ", numberSale=" + numberSale +
                ", dateSale=" + dateSale +
                ", subTotal=" + subTotal +
                ", discount=" + discount +
                ", iva=" + iva +
                ", total=" + total +
                ", methodPayment='" + methodPayment + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
