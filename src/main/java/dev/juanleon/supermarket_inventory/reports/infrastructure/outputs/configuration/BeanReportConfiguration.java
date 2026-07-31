package dev.juanleon.supermarket_inventory.reports.infrastructure.outputs.configuration;

import dev.juanleon.supermarket_inventory.common.configuration.AppConfigurationProperties;
import dev.juanleon.supermarket_inventory.employees.domain.services.get.IGetEmployeeService;
import dev.juanleon.supermarket_inventory.files.domain.IFilesService;
import dev.juanleon.supermarket_inventory.reports.domain.persistence.delete.IDeleteReportPersistence;
import dev.juanleon.supermarket_inventory.reports.domain.persistence.get.IGetReportPersistence;
import dev.juanleon.supermarket_inventory.reports.domain.persistence.post.IPostReportPersistence;
import dev.juanleon.supermarket_inventory.reports.domain.ports.IPortEmployeeReportsGet;
import dev.juanleon.supermarket_inventory.reports.domain.ports.IPortFilesReports;
import dev.juanleon.supermarket_inventory.reports.domain.services.delete.IDeleteReportService;
import dev.juanleon.supermarket_inventory.reports.domain.services.get.IGetReportService;
import dev.juanleon.supermarket_inventory.reports.domain.services.post.IPostReportService;
import dev.juanleon.supermarket_inventory.reports.domain.useCases.delete.DeleteReportUseCases;
import dev.juanleon.supermarket_inventory.reports.domain.useCases.get.GetReportUseCase;
import dev.juanleon.supermarket_inventory.reports.domain.useCases.post.PostReportUseCase;
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
            IPortEmployeeReportsGet iPortEmployeeReportsGet,
            IPortFilesReports iPortFilesReports,
            AppConfigurationProperties appConfigurationProperties
    ) {
        return new PostReportUseCase(
                iPostReportPersistence,
                iPortEmployeeReportsGet,
                iPortFilesReports,
                appConfigurationProperties
        );
    }

    @Bean
    public IDeleteReportService iDeleteReportService(
            IDeleteReportPersistence iDeleteReportPersistence,
            IPortFilesReports iPortFilesReports,
            AppConfigurationProperties appConfigurationProperties
    ) {
        return new DeleteReportUseCases(
                iDeleteReportPersistence,
                iPortFilesReports,
                appConfigurationProperties
        );
    }
}
