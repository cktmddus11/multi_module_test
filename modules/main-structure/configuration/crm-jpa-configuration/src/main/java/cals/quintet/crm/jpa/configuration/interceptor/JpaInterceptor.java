package cals.quintet.crm.jpa.configuration.interceptor;

import maestro.quintet.crm.data.datasource.TenantRoutingDataSourceContextHolder;
import org.hibernate.resource.jdbc.spi.StatementInspector;

/**
 * @author sycha
 * @since 1.0
 */
public class JpaInterceptor implements StatementInspector {
    @Override
    public String inspect (String sql) {
        String schema = TenantRoutingDataSourceContextHolder.getClientDatabase().getTenantSchemaNm();
        return sql.replaceAll("#TENANT#", schema);
    }
}
