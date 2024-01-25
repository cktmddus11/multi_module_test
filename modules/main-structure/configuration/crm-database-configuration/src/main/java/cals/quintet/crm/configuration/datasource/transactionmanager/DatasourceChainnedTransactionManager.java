package cals.quintet.crm.configuration.datasource.transactionmanager;

import cals.quintet.crm.configuration.datasource.conts.TenantDataSourceBeanName;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.transaction.ChainedTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * @author sycha
 * @since 1.0
 */


@Slf4j
@Configuration
public class DatasourceChainnedTransactionManager {


    @Bean("datasourceChainedTransactionManager")
    public PlatformTransactionManager chainedTransactionManager (
            @Qualifier(TenantDataSourceBeanName.DATASOURCE_CRM_TRANSACTION_MANAGER_FACTORY) PlatformTransactionManager crmDbTransactionManager,
            @Qualifier(TenantDataSourceBeanName.DATASOURCE_LOY_CORE_TRANSACTION_MANAGER_FACTORY) PlatformTransactionManager loycoreDbTransactionManager) {

        log.info("=============== datasource chainedTransactionManager Complete...  =================== ");

        return new ChainedTransactionManager(crmDbTransactionManager, loycoreDbTransactionManager);
    }

}
