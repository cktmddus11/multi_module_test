package cals.quintet.crm.tenant.datasource.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author sycha
 * @since 1.0
 */
@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "datasource.main")
public class MainDataSourceProperties {
    private String url;
    private String username;
    private String password;
    private String driverClassName;
}
