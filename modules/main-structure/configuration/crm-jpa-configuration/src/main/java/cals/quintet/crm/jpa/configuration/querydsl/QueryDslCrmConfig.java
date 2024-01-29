package cals.quintet.crm.jpa.configuration.querydsl;

import cals.quintet.crm.configuration.datasource.conts.TenantDataSourceBeanName;
import com.querydsl.jpa.JPQLQueryFactory;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author sycha
 * @since 1.0
 */

@Slf4j
@RequiredArgsConstructor
@Configuration
public class QueryDslCrmConfig {

    @PersistenceContext(unitName = TenantDataSourceBeanName.CRM_ENTITY_MANAGER)
    private  EntityManager entityManager;
    @Bean(name=TenantDataSourceBeanName.CRM_QUERY_FACTORY)
    public JPQLQueryFactory crmJpaQueryFactory(){
        log.info("============= crmJpaQueryFactory Complete...  ==============");

        return new JPAQueryFactory(entityManager);
    }
}
