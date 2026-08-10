package dev.juanleon.supermarket_inventory.modules.employees.infrastructure.outputs.database.adapters.delete;

import dev.juanleon.supermarket_inventory.modules.employees.domain.persistence.delete.IDeleteEmployeePersistence;
import dev.juanleon.supermarket_inventory.modules.employees.infrastructure.outputs.database.repositories.IEmployeeRepository;
import dev.juanleon.supermarket_inventory.modules.employees.infrastructure.outputs.exceptions.NotFoundEmployeeException;
import dev.juanleon.supermarket_inventory.share.files.events.FileDeletedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Repository;

import java.util.UUID;

import static dev.juanleon.supermarket_inventory.share.configuration.AppConfigurationProperties.PATH_UPLOAD_IMAGES_EMPLOYEES;
import static dev.juanleon.supermarket_inventory.share.utils.enums.MessagesApp.EMPLOYEE_DELETED_SUCCESSFULLY_BY_ID;

@Repository
@RequiredArgsConstructor
public class DeleteEmployeeAdapter implements IDeleteEmployeePersistence {

    private final IEmployeeRepository iEmployeeRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

    @Override
    public String deleteEmployeeAndUser(UUID idEmployee) {
        return this.iEmployeeRepository.findById(idEmployee)
                .map(entity -> {
                    this.applicationEventPublisher.publishEvent(new FileDeletedEvent(
                            entity.getUrlImg(),
                            PATH_UPLOAD_IMAGES_EMPLOYEES
                    ));
                    this.iEmployeeRepository.deleteById(entity.getId());
                    return EMPLOYEE_DELETED_SUCCESSFULLY_BY_ID.format(entity.getId());
                }).orElseThrow(() -> new NotFoundEmployeeException(idEmployee));
    }
}
