package dev.juanleon.supermarket_inventory.modules.employees.infrastructure.outputs.providers;

import dev.juanleon.supermarket_inventory.modules.employees.domain.models.EmployeeModel;
import dev.juanleon.supermarket_inventory.modules.employees.infrastructure.outputs.database.mappers.IMapperEmployeeInfrastructure;
import dev.juanleon.supermarket_inventory.modules.employees.infrastructure.outputs.database.repositories.IEmployeeRepository;
import dev.juanleon.supermarket_inventory.modules.employees.infrastructure.outputs.exceptions.NotFoundEmployeeException;
import dev.juanleon.supermarket_inventory.modules.sales.domain.ports.IEmployeeProviderSales;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class SalesEmployeeProviderAdapter implements IEmployeeProviderSales {

    private final IEmployeeRepository iEmployeeRepository;
    private final IMapperEmployeeInfrastructure iMapperEmployeeInfrastructure;

    @Override
    public EmployeeModel getEmployeeById(UUID id) {
        return this.iEmployeeRepository.findById(id)
                .map(this.iMapperEmployeeInfrastructure::toModel)
                .orElseThrow(() -> new NotFoundEmployeeException(id));
    }
}
