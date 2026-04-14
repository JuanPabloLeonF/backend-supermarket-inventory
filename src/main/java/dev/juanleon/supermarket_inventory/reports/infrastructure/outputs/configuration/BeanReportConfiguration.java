package dev.juanleon.supermarket_inventory.reports.infrastructure.outputs.configuration;

import dev.juanleon.supermarket_inventory.employees.domain.services.get.IGetEmployeeService;
import dev.juanleon.supermarket_inventory.files.domain.IFilesService;
import dev.juanleon.supermarket_inventory.reports.domain.persistence.delete.IDeleteReportPersistence;
import dev.juanleon.supermarket_inventory.reports.domain.persistence.get.IGetReportPersistence;
import dev.juanleon.supermarket_inventory.reports.domain.persistence.post.IPostReportPersistence;
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
            IGetEmployeeService iGetEmployeeService,
            IFilesService iFilesService
    ) {
        return new PostReportUseCase(
                iPostReportPersistence,
                iGetEmployeeService,
                iFilesService
        );
    }

    @Bean
    public IDeleteReportService iDeleteReportService(
            IDeleteReportPersistence iDeleteReportPersistence,
            IFilesService iFilesService
    ) {
        return new DeleteReportUseCases(
                iDeleteReportPersistence,
                iFilesService
        );
    }
}
