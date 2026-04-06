package dev.juanleon.supermarket_inventory.employees.infrastructure.outputs.database.adapters.get;

import dev.juanleon.supermarket_inventory.common.utils.dto.PagedResponse;
import dev.juanleon.supermarket_inventory.common.utils.dto.PaginationRequest;
import dev.juanleon.supermarket_inventory.common.utils.mappers.IMapperPaginationApp;
import dev.juanleon.supermarket_inventory.employees.domain.models.EmployeeModel;
import dev.juanleon.supermarket_inventory.employees.domain.persistence.get.IGetEmployeePersistence;
import dev.juanleon.supermarket_inventory.employees.infrastructure.outputs.database.entities.EmployeeEntity;
import dev.juanleon.supermarket_inventory.employees.infrastructure.outputs.database.mappers.IMapperEmployeeInfrastructure;
import dev.juanleon.supermarket_inventory.employees.infrastructure.outputs.database.repositories.IEmployeeRepository;
import dev.juanleon.supermarket_inventory.employees.infrastructure.outputs.exceptions.NotFoundEmployeeException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class GetEmployeeAdapter implements IGetEmployeePersistence {

    private final IEmployeeRepository iEmployeeRepository;
    private final IMapperPaginationApp iMapperPaginationApp;
    private final IMapperEmployeeInfrastructure iMapperEmployeeInfrastructure;

    @Override
    public PagedResponse<EmployeeModel> getAll(PaginationRequest paginationRequest) {
        Pageable pageable = this.iMapperPaginationApp.toPageable(paginationRequest);
        Page<EmployeeEntity> entityPage = this.iEmployeeRepository.findAll(pageable);
        return this.iMapperPaginationApp.pagetoPagedResponse(entityPage, this.iMapperEmployeeInfrastructure::toModel);
    }

    @Override
    public EmployeeModel getById(UUID id) {
        return this.iEmployeeRepository.findById(id)
                .map(this.iMapperEmployeeInfrastructure::toModel)
                .orElseThrow(() -> new NotFoundEmployeeException(id));
    }

    @Override
    public PagedResponse<EmployeeModel> getByNameAndLastName(String name, String lastName, PaginationRequest paginationRequest) {
        Pageable pageable = this.iMapperPaginationApp.toPageable(paginationRequest);
        Page<EmployeeEntity> entityPage = iEmployeeRepository.findByUserEntity_NameAndUserEntity_LastName(name, lastName, pageable);
        return this.iMapperPaginationApp.pagetoPagedResponse(entityPage, this.iMapperEmployeeInfrastructure::toModel);
    }

    @Override
    public PagedResponse<EmployeeModel> getByPosition(String position, PaginationRequest paginationRequest) {
        Pageable pageable = this.iMapperPaginationApp.toPageable(paginationRequest);
        Page<EmployeeEntity> entityPage = iEmployeeRepository.findByPosition(position, pageable);
        return this.iMapperPaginationApp.pagetoPagedResponse(entityPage, this.iMapperEmployeeInfrastructure::toModel);
    }

    @Override
    public PagedResponse<EmployeeModel> getByHireDate(LocalDateTime hireDate, PaginationRequest paginationRequest) {
        Pageable pageable = this.iMapperPaginationApp.toPageable(paginationRequest);
        Page<EmployeeEntity> entityPage = iEmployeeRepository.findByHireDateGreaterThanEqual(hireDate, pageable);
        return this.iMapperPaginationApp.pagetoPagedResponse(entityPage, this.iMapperEmployeeInfrastructure::toModel);
    }
}
