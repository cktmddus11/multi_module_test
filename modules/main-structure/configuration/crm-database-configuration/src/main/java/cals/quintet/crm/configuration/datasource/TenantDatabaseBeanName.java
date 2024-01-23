package cals.quintet.crm.configuration.datasource;

import lombok.Getter;

/**
 * @author sycha
 * @since 1.0
 */
@Getter
public class TenantDatabaseBeanName {
    public static final String TENANT_DATASOURCE = "tenantDataSource";
    public static final String TENANT_JDBCTEMPLATE = "tenantJdbcTemplate";

}
