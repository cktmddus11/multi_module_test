package cals.quintet.crm.configuration.datasource;

import cals.quintet.crm.configuration.datasource.properties.TenantADataSourceProperties;
import cals.quintet.crm.configuration.datasource.properties.TenantBDataSourceProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import maestro.quintet.crm.datasource.ClientDataSouceRouter;
import maestro.quintet.crm.datasource.ClientDatabase;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sycha
 * @since 1.0
 */
@Slf4j

@RequiredArgsConstructor
@Configuration
public class TenantRoutingDatabaseConfig {

    private final TenantADataSourceProperties aDataSourceProperties;
    private final TenantBDataSourceProperties bDataSourceProperties;

    @Bean(name="routeDataSource")
    public DataSource dataSource(){
        Map<Object, Object> targetDataSource = new HashMap<>();
        //  TODO 테넌트 메타 데이터 읽어서 처리

        log.info("============= dataSource Setting...  ==============");

        DataSourceBuilder<?> aDataSourceBuilder = DataSourceBuilder.create()
                .driverClassName(aDataSourceProperties.getDriverClassName())
                .url(aDataSourceProperties.getUrl())
                .username(aDataSourceProperties.getUsername())
                .password(aDataSourceProperties.getPassword());
        targetDataSource.put(ClientDatabase.TENANTA, aDataSourceBuilder.build());

        DataSourceBuilder<?> bDataSourceBuilder = DataSourceBuilder.create()
                .driverClassName(bDataSourceProperties.getDriverClassName())
                .url(bDataSourceProperties.getUrl())
                .username(bDataSourceProperties.getUsername())
                .password(bDataSourceProperties.getPassword());
        targetDataSource.put(ClientDatabase.TENANTB, bDataSourceBuilder.build());

        ClientDataSouceRouter dataSouceRouter = new ClientDataSouceRouter();
        dataSouceRouter.setTargetDataSources(targetDataSource);
        dataSouceRouter.setDefaultTargetDataSource(aDataSourceBuilder.build());

        log.info("============= dataSource Complete...  ==============");


        return dataSouceRouter;
    }
}
