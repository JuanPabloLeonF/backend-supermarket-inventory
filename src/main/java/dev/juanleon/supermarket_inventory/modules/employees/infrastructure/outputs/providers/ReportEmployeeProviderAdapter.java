package dev.juanleon.supermarket_inventory.modules.employees.infrastructure.outputs.providers;

import dev.juanleon.supermarket_inventory.modules.employees.domain.models.EmployeeModel;
import dev.juanleon.supermarket_inventory.modules.employees.infrastructure.outputs.database.mappers.IMapperEmployeeInfrastructure;
import dev.juanleon.supermarket_inventory.modules.employees.infrastructure.outputs.database.repositories.IEmployeeRepository;
import dev.juanleon.supermarket_inventory.modules.products.infrastructure.outputs.exceptions.NotFoundProductException;
import dev.juanleon.supermarket_inventory.modules.reports.domain.ports.IEmployeeProviderReport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ReportEmployeeProviderAdapter implements IEmployeeProviderReport {

    private final IEmployeeRepository iEmployeeRepository;
    private final IMapperEmployeeInfrastructure iMapperEmployeeInfrastructure;

    @Override
    public EmployeeModel getEmployeeById(UUID id) {
        return this.iEmployeeRepository.findById(id)
                .map(this.iMapperEmployeeInfrastructure::toModel)
                .orElseThrow(() -> new NotFoundProductException(id));
    }
}
