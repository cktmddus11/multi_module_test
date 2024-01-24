package cals.quintet.crm.jpa.configuration.transactionmanager;

import cals.quintet.crm.configuration.datasource.conts.TenantDataSourceBeanName;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.transaction.ChainedTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * @author sycha
 * @since 1.0
 */
@Slf4j
@Configuration
public class JpaChainnedTransactionManager {

    @Primary
    @Bean("JpaChainedTransactionManager")
    public PlatformTransactionManager chainedTransactionManager (
            @Qualifier(TenantDataSourceBeanName.JPA_CRM_TRANSACTION_MANAGER_FACTORY) PlatformTransactionManager crmDbTransactionManager,
            @Qualifier(TenantDataSourceBeanName.JPA_LOY_CORE_TRANSACTION_MANAGER_FACTORY) PlatformTransactionManager loycoreDbTransactionManager) {

        log.info("=============== jpa chainedTransactionManager Complete =================== ");

        return new ChainedTransactionManager(crmDbTransactionManager, loycoreDbTransactionManager);
    }

}
