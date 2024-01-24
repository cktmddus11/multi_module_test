package cals.quintet.crm.tenant.search.repository.template;

import cals.quintet.crm.tenant.datasource.MainDatabaseBeanName;
import cals.quintet.crm.tenant.search.model.vo.TenantDatasourceVo;
import cals.quintet.crm.tenant.type.DatabaseType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sycha
 * @since 1.0
 */
@Repository
public class TenantDatasourceRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TenantDatasourceRepository (@Qualifier(MainDatabaseBeanName.META_JDBCTEMPLATE) JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<TenantDatasourceVo> getTenantDatasource (DatabaseType dbType) {
        final String sql = """
                SELECT
                      A.tenant_name     AS tenantName
                    , A.tenant_code     AS tenantCode
                    , B.url
                    , B.username
                    , B.password
                    , B.driver_class_name AS driverClassName
                FROM main.tenant A 
                JOIN main.tenant_datasource B on A.id = B.tenant_id 
                WHERE 1=1 
                and B.db_type = ?
                """;


        return jdbcTemplate.query(sql, rowMapper, dbType.toString().toLowerCase() );
    }

    private final RowMapper<TenantDatasourceVo> rowMapper =
            (rs, rowNum) -> TenantDatasourceVo.builder()
                    .tenantName(rs.getString("tenantName"))
                    .tenantCode(rs.getString("tenantCode"))
                    .url(rs.getString("url"))
                    .username(rs.getString("username"))
                    .password(rs.getString("password"))
                    .driverClassName(rs.getString("driverClassName"))
                    .build();
}


