package cals.quintet.crm.tenant.jdbctemplate;

import cals.quintet.crm.tenant.datasource.MainDatabaseBeanName;
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
public class MainJdbcTemplateConfig implements DefaultJdbcTemplate {

    @Bean(MainDatabaseBeanName.META_JDBCTEMPLATE)
    public JdbcTemplate jdbcTemplate (@Qualifier(MainDatabaseBeanName.META_DATASOURCE) DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
    @Override
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate (DataSource dataSource) {
        return null;
    }
}
