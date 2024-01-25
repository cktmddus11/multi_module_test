package cals.quintet.crm.jpa.configuration;

import cals.quintet.crm.configuration.datasource.conts.TenantDataSourceBeanName;
import cals.quintet.crm.jpa.configuration.interceptor.JpaInterceptor;
import jakarta.persistence.EntityManagerFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import maestro.quintet.crm.data.jpa.AbstractJpaConfig;
import org.hibernate.cfg.AvailableSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author sycha
 * @since 1.0
 */

@Slf4j
//@EntityScan(basePackages = "cals.quintet.crm.**.entity.crm")
@EnableJpaRepositories(
        basePackages = "cals.quintet.crm.**.repository.mapper.crm",  // 리포지토리 스캔 경로
        transactionManagerRef = TenantDataSourceBeanName.JPA_CRM_TRANSACTION_MANAGER_FACTORY,
        entityManagerFactoryRef = TenantDataSourceBeanName.CRM_ENTITY_MANAGER_FACTORY // ㅇefault 값이라 삭제함
)
@RequiredArgsConstructor
@Configuration
public class JpaCrmDataSourceConfig extends AbstractJpaConfig {
    @Bean(name = TenantDataSourceBeanName.CRM_ENTITY_MANAGER_FACTORY)
    @Override
    public LocalContainerEntityManagerFactoryBean entityManagerFactory (@Qualifier(TenantDataSourceBeanName.CRM_TENANT_DATASOURCE) DataSource dataSource) {

        log.info("============= crm jpaEntityManager Setting...  ==============");

        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan("cals.quintet.crm.business.domain.entity.crm");

        Properties jpaProperties = new Properties();
        jpaProperties.put(AvailableSettings.STATEMENT_INSPECTOR, JpaInterceptor.class);
        em.setJpaProperties(jpaProperties);

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);

        log.info("============= crm jpaEntityManager Complete...  ==============");
        return em;
    }


    @Bean(name = TenantDataSourceBeanName.JPA_CRM_TRANSACTION_MANAGER_FACTORY)
    @Override
    public PlatformTransactionManager transactionManager (
            @Autowired @Qualifier(TenantDataSourceBeanName.CRM_ENTITY_MANAGER_FACTORY) EntityManagerFactory entityManagerFactory) {
        log.info("============= crm transactionManager Complete...  ==============");
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }


}
