/*
package cals.quintet.crm.configuration.datasource;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

*/
/**
 * @author sycha
 * @since 1.0
 *//*

@Component
public class DatabaseProvider implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }


    @Getter
    @RequiredArgsConstructor
    public enum DatabaseType {
        META_DB(TenantDatabaseBeanName.META_DATASOURCE, "metaTransactionManager", TenantDatabaseBeanName.META_JDBCTEMPLATE),
        TENANT_DB("tenantDataSource", "tenantTransactionManager", TenantDatabaseBeanName.TENANT_JDBCTEMPLATE)
        ;

        private final String dataSourceName;
        private final String transactionManagerName;
        private final String jdbcTemplateName;
    }

    public DataSource getDataSource(DatabaseType dbType) {
        return applicationContext.getBean(
                dbType.getDataSourceName(),
                DataSource.class
        );
    }

    public PlatformTransactionManager getTransactionManager(DatabaseType dbType) {
        return applicationContext.getBean(
                dbType.getTransactionManagerName(),
                PlatformTransactionManager.class
        );
    }

    public JdbcTemplate getJdbcTemplate(DatabaseType dbType) {
        return applicationContext.getBean(
                dbType.getJdbcTemplateName(),
                JdbcTemplate.class
        );
    }

    */
/*public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate(DatabaseType dbType) {
        return applicationContext.getBean(
                dbType.getNamedJdbcTemplateName(),
                NamedParameterJdbcTemplate.class
        );
    }*//*

}
*/
