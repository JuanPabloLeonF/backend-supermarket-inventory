package dev.juanleon.supermarket_inventory.modules.reports.domain.persistence.delete;

import java.util.UUID;

public interface IDeleteReportPersistence {
    String deleteById(UUID id);
}
