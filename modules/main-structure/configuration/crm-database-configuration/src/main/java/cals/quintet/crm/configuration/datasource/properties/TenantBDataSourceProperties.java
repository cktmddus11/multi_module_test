package cals.quintet.crm.configuration.datasource.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author sycha
 * @since 1.0
 */
@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "datasource.tenant-b")
public class TenantBDataSourceProperties {
    private String url;
    private String username;
    private String password;

    private String driverClassName;

}
