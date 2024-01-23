package cals.quintet.crm.tenant.search.model.vo;

import lombok.Builder;
import lombok.Getter;

/**
 * @author sycha
 * @since 1.0
 */
@Builder
@Getter
public class TenantDatasourceVo {
    private String tenantName;
    private String tenantCode;

    private String url;
    private String username;
    private String password;
    private String driverClassName;
}
