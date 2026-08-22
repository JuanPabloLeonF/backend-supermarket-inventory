package dev.juanleon.supermarket_inventory.modules.sales.infrastructure.outputs.providers;

import dev.juanleon.supermarket_inventory.modules.employees.infrastructure.outputs.exceptions.NotFoundEmployeeException;
import dev.juanleon.supermarket_inventory.modules.reports.domain.ports.ISaleProviderReport;
import dev.juanleon.supermarket_inventory.modules.sales.domain.models.SalesModel;
import dev.juanleon.supermarket_inventory.modules.sales.infrastructure.outputs.database.mappers.IMapperSalesInfrastructure;
import dev.juanleon.supermarket_inventory.modules.sales.infrastructure.outputs.database.repositories.ISalesRepository;
import dev.juanleon.supermarket_inventory.modules.sales.infrastructure.outputs.exceptions.NotFoundSalesException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ReportSalesProviderAdapter implements ISaleProviderReport {

    private final ISalesRepository iSalesRepository;
    private final IMapperSalesInfrastructure iMapperSalesInfrastructure;

    @Override
    public SalesModel getSaleById(UUID saleId, UUID employeeId) {
        return this.iSalesRepository.findById(saleId)
                .map((entity) -> {

                    if (!employeeId.equals(entity.getEmployee().getId())) {
                        throw new NotFoundEmployeeException(employeeId);
                    }

                    return this.iMapperSalesInfrastructure.toModel(entity);
                }).orElseThrow(() -> new NotFoundSalesException(saleId));
    }
}
