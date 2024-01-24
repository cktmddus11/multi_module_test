package cals.quintet.crm.configuration.jdbctemplate;

import cals.quintet.crm.configuration.datasource.conts.TenantDataSourceBeanName;
import maestro.quintet.crm.data.jdbctemplate.DefaultJdbcTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

/**
 * @author sycha
 * @since 1.0
 */
@Configuration
public class TenantJdbcTemplateConfig implements DefaultJdbcTemplate {

    @Bean(TenantDataSourceBeanName.TENANT_JDBCTEMPLATE)
    public JdbcTemplate jdbcTemplate (@Qualifier(TenantDataSourceBeanName.CRM_TENANT_DATASOURCE) DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Override
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate (DataSource dataSource) {
        return null;
    }
}
