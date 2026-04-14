package dev.juanleon.supermarket_inventory.reports.infrastructure.outputs.database.adapters.delete;

import dev.juanleon.supermarket_inventory.reports.domain.persistence.delete.IDeleteReportPersistence;
import dev.juanleon.supermarket_inventory.reports.infrastructure.outputs.database.repositories.IReportRepository;
import dev.juanleon.supermarket_inventory.reports.infrastructure.outputs.exceptions.NotFoundReportException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class DeleteReportAdapter implements IDeleteReportPersistence {

    private final IReportRepository iReportRepository;

    @Override
    public String deleteById(UUID id) {
         return this.iReportRepository.findById(id)
                .map(entity -> {
                    this.iReportRepository.deleteById(entity.getId());
                    return entity.getFilePath();
                }).orElseThrow(() -> new NotFoundReportException(id));
    }
}
