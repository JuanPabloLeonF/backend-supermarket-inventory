package dev.juanleon.supermarket_inventory.modules.purchases.infrastructure.outputs.providers;

import dev.juanleon.supermarket_inventory.modules.employees.infrastructure.outputs.exceptions.NotFoundEmployeeException;
import dev.juanleon.supermarket_inventory.modules.providers.infrastructure.outputs.exceptions.NotFoundProviderException;
import dev.juanleon.supermarket_inventory.modules.purchases.domain.models.PurchaseModel;
import dev.juanleon.supermarket_inventory.modules.purchases.infrastructure.outputs.database.mappers.IMapperPurchaseInfrastructure;
import dev.juanleon.supermarket_inventory.modules.purchases.infrastructure.outputs.database.repositories.IPurchaseRepository;
import dev.juanleon.supermarket_inventory.modules.purchases.infrastructure.outputs.exceptions.NotFoundPurchaseException;
import dev.juanleon.supermarket_inventory.modules.reports.domain.ports.IPurchaseProviderReport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ReportPurchaseProviderAdapter implements IPurchaseProviderReport {

    private final IPurchaseRepository iPurchaseRepository;
    private final IMapperPurchaseInfrastructure iMapperPurchaseInfrastructure;

    @Override
    public PurchaseModel getPurchaseById(UUID idPurchase, UUID idEmployee, UUID idProvider) {
        return this.iPurchaseRepository.findById(idPurchase)
                .map(entity -> {

                    if (!entity.getEmployeeEntity().getId().equals(idEmployee)) {
                        throw new NotFoundEmployeeException(idEmployee);
                    }

                    if (!entity.getProviderEntity().getId().equals(idProvider)) {
                        throw new NotFoundProviderException(idProvider);
                    }

                    return this.iMapperPurchaseInfrastructure.toModel(entity);
                }).orElseThrow(() -> new NotFoundPurchaseException(idPurchase));
    }
}
