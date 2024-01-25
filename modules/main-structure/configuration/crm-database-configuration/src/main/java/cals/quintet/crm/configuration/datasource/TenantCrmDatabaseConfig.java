package cals.quintet.crm.configuration.datasource;

import cals.quintet.crm.configuration.datasource.conts.TenantDataSourceBeanName;
import cals.quintet.crm.tenant.search.model.vo.TenantDatasourceVo;
import cals.quintet.crm.tenant.search.service.MetaDataSourceSearchService;
import cals.quintet.crm.tenant.type.DatabaseType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import maestro.quintet.crm.data.datasource.TenantDataSouceRouter;
import maestro.quintet.crm.data.datasource.TenantDatabase;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.yaml.snakeyaml.util.EnumUtils;

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
public class TenantCrmDatabaseConfig {
    private final MetaDataSourceSearchService metaDataSourceSearchService;

    @Lazy
    @Bean(name = TenantDataSourceBeanName.CRM_TENANT_DATASOURCE)
    public DataSource dataSource () throws Exception {
        log.info("============= tenant Crm dataSource Setting...  ==============");

        Map<String, TenantDatasourceVo> tenantDatasourceVoMap = metaDataSourceSearchService.searchTenantDatasource(DatabaseType.CRM);
        if (tenantDatasourceVoMap.isEmpty()) {
            log.info("tenant datasource is empty");
        }

        Map<Object, Object> targetDataSource = makeTargetDataSourceMap(tenantDatasourceVoMap);

        TenantDataSouceRouter dataSouceRouter = new TenantDataSouceRouter();
        dataSouceRouter.setTargetDataSources(targetDataSource);
        dataSouceRouter.setDefaultTargetDataSource(targetDataSource.get(TenantDatabase.TENANTA));

        log.info("============= tenant Crm dataSource Complete...  ==============");

        return dataSouceRouter;
    }

    @Bean(name = TenantDataSourceBeanName.DATASOURCE_CRM_TRANSACTION_MANAGER_FACTORY)
    public PlatformTransactionManager platformTransactionManager (@Qualifier(TenantDataSourceBeanName.CRM_TENANT_DATASOURCE) DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }


    private static Map<Object, Object> makeTargetDataSourceMap (Map<String, TenantDatasourceVo> tenantDatasourceVoMap) {
        Map<Object, Object> targetDataSource = new HashMap<>();

        for (Map.Entry<String, TenantDatasourceVo> entrySet : tenantDatasourceVoMap.entrySet()) {
            TenantDatasourceVo datasourceVo = entrySet.getValue();

            DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create()
                    .driverClassName(datasourceVo.getDriverClassName())
                    .url(datasourceVo.getUrl())
                    .username(datasourceVo.getUsername())
                    .password(datasourceVo.getPassword());

            TenantDatabase tenantDatabase = TenantDatabase.valueOf(datasourceVo.getTenantCode());
          //  TenantDatabase tenantDatabase = TenantDatabase.convertEumCode(datasourceVo.getTenantCode());

            targetDataSource.put(tenantDatabase, dataSourceBuilder.build());

            log.info(tenantDatabase.getTenantSchemaNm() + " : " + datasourceVo.getUrl());
        }
        return targetDataSource;
    }


}
