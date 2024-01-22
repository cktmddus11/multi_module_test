package cals.quintet.crm.jpa.configuration;

import cals.quintet.crm.configuration.datasource.TenantRoutingDatabaseConfig;
import jakarta.persistence.EntityManagerFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import maestro.quintet.crm.data.jpa.AbstractJpaConfig;
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
@EntityScan(basePackages = "cals.quintet.crm.**.entity")
@EnableJpaRepositories(
        basePackages = "cals.quintet.crm.**.mapper.repository"  // 리포지토리 스캔 경로
        //    transactionManagerRef = "transactionManager"
        //  entityManagerFactoryRef = "entityManagerFactory" // ㅇefault 값이라 삭제함
)
@RequiredArgsConstructor
@Configuration
public class JpaDataSourceConfig extends AbstractJpaConfig {
    private final TenantRoutingDatabaseConfig dataSource;

    @Bean(name = "entityManagerFactory")
    @Override
    public LocalContainerEntityManagerFactoryBean entityManagerFactory (@Qualifier("routeDataSource") DataSource dataSource) {

        log.info("============= jpaEntityManager Setting...  ==============");

        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan("cals.quintet.crm.business.domain");

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);

        //        Properties jpaProperties = new Properties();
        //        jpaProperties.put("hibernate.show_sql", "true");
        //        jpaProperties.put("hibernate.hbm2ddl.auto", "update");
        //        em.setJpaProperties(jpaProperties);

        log.info("============= jpaEntityManager Complete...  ==============");


        return em;
    }


    @Bean(name = "transactionManager")
    @Override
    public PlatformTransactionManager transactionManager (
            @Autowired @Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory) {
        log.info("============= transactionManager Setting...  ==============");
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }


}
