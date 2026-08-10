package dev.juanleon.supermarket_inventory.modules.reports.infrastructure.outputs.configuration;

import dev.juanleon.supermarket_inventory.modules.reports.domain.persistence.delete.IDeleteReportPersistence;
import dev.juanleon.supermarket_inventory.modules.reports.domain.persistence.get.IGetReportPersistence;
import dev.juanleon.supermarket_inventory.modules.reports.domain.persistence.post.IPostReportPersistence;
import dev.juanleon.supermarket_inventory.modules.reports.domain.ports.IEmployeeProviderReport;
import dev.juanleon.supermarket_inventory.modules.reports.domain.ports.IFilesProviderReport;
import dev.juanleon.supermarket_inventory.modules.reports.domain.services.delete.IDeleteReportService;
import dev.juanleon.supermarket_inventory.modules.reports.domain.services.get.IGetReportService;
import dev.juanleon.supermarket_inventory.modules.reports.domain.services.post.IPostReportService;
import dev.juanleon.supermarket_inventory.modules.reports.domain.useCases.delete.DeleteReportUseCases;
import dev.juanleon.supermarket_inventory.modules.reports.domain.useCases.get.GetReportUseCase;
import dev.juanleon.supermarket_inventory.modules.reports.domain.useCases.post.PostReportUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanReportConfiguration {

    @Bean
    public IGetReportService iGetReportService(IGetReportPersistence iGetReportPersistence) {
        return new GetReportUseCase(iGetReportPersistence);
    }

    @Bean
    public IPostReportService iPostReportService(
            IPostReportPersistence iPostReportPersistence,
            IEmployeeProviderReport iEmployeeProviderReport,
            IFilesProviderReport iFilesProviderReport
    ) {
        return new PostReportUseCase(
                iPostReportPersistence,
                iEmployeeProviderReport,
                iFilesProviderReport
        );
    }

    @Bean
    public IDeleteReportService iDeleteReportService(IDeleteReportPersistence iDeleteReportPersistence) {
        return new DeleteReportUseCases(iDeleteReportPersistence);
    }
}
