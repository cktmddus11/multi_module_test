package cals.quintet.crm.configuration.datasource;

import cals.quintet.crm.tenant.search.model.vo.TenantDatasourceVo;
import cals.quintet.crm.tenant.search.service.TenantDatasourceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import maestro.quintet.crm.data.datasource.TenantDataSouceRouter;
import maestro.quintet.crm.data.datasource.TenantDatabase;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

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
public class TenantDatabaseConfig {
    private final TenantDatasourceService tenantDatasourceService;

    @Lazy
    @Bean(name= TenantDatabaseBeanName.TENANT_DATASOURCE)
    public DataSource dataSource() throws Exception {
        Map<Object, Object> targetDataSource = new HashMap<>();

        log.info("============= tenant dataSource Setting...  ==============");

        Map<String, TenantDatasourceVo> tenantDatasourceVoMap = tenantDatasourceService.searchTenantDatasource();
        if(tenantDatasourceVoMap.isEmpty()){
           log.info("tenant datasource is empty");
        }
        for(Map.Entry<String, TenantDatasourceVo> entrySet : tenantDatasourceVoMap.entrySet()){
            TenantDatasourceVo datasourceVo = entrySet.getValue();
            DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create()
                    .driverClassName(datasourceVo.getDriverClassName())
                    .url(datasourceVo.getUrl())
                    .username(datasourceVo.getUsername())
                    .password(datasourceVo.getPassword());
            TenantDatabase tenantDatabase = TenantDatabase.convertEumCode(datasourceVo.getTenantCode());

            targetDataSource.put(tenantDatabase, dataSourceBuilder.build());

            log.info(tenantDatabase.getTenantCode().toString()+" : "+datasourceVo.getUrl());
        }

        TenantDataSouceRouter dataSouceRouter = new TenantDataSouceRouter();
        dataSouceRouter.setTargetDataSources(targetDataSource);
        dataSouceRouter.setDefaultTargetDataSource(targetDataSource.get(TenantDatabase.TENANTA));

        log.info("============= tenant dataSource Complete...  ==============");

        return dataSouceRouter;
    }
}
