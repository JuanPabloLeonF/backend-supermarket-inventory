package dev.juanleon.supermarket_inventory.modules.providers.infrastructure.outputs.database.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "providers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProviderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(unique = true, nullable = false)
    private String identification;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(name = "cell_phone", nullable = false)
    private String cellPhone;

    @Column(nullable = false)
    private String direction;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private Boolean activate;

    @Column(nullable = false)
    private LocalDate createdAt;
}
