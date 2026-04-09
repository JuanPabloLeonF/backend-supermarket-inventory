package dev.juanleon.supermarket_inventory.reports.infrastructure.outputs.configuration;

import dev.juanleon.supermarket_inventory.reports.domain.persistence.get.IGetReportPersistence;
import dev.juanleon.supermarket_inventory.reports.domain.services.get.IGetReportService;
import dev.juanleon.supermarket_inventory.reports.domain.useCases.get.GetReportUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanReportConfiguration {

    @Bean
    public IGetReportService iGetReportService(IGetReportPersistence iGetReportPersistence) {
        return new GetReportUseCase(iGetReportPersistence);
    }
}
