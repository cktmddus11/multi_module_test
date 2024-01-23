package cals.quintet.crm.tenant.datasource;

import cals.quintet.crm.tenant.datasource.properties.MainDataSourceProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.DriverManager;

/**
 * @author sycha
 * @since 1.0
 */
@Slf4j

@RequiredArgsConstructor
@Configuration
public class MainDatabaseConfig {

    private final MainDataSourceProperties mainDataSourceProperties;

    @Bean(name= MainDatabaseBeanName.META_DATASOURCE)
    public DataSource dataSource() {
        log.info("============= main dataSource Setting...  ==============");

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(mainDataSourceProperties.getUrl());
        dataSource.setUsername(mainDataSourceProperties.getUsername());
        dataSource.setPassword(mainDataSourceProperties.getPassword());
        dataSource.setDriverClassName(mainDataSourceProperties.getDriverClassName());

        log.info("main : "+mainDataSourceProperties.getUrl());
        log.info("============= main Complete...  ==============");

        return dataSource;
    }
}
