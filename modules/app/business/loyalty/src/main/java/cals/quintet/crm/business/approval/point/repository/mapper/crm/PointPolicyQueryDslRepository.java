package cals.quintet.crm.business.approval.point.repository.mapper.crm;

import cals.quintet.crm.configuration.datasource.conts.TenantDataSourceBeanName;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Repository;

import static cals.quintet.crm.business.domain.entity.crm.QPointPolicy.pointPolicy;

/**
 * @author sycha
 * @since 1.0
 */
@Repository
//@RequiredArgsConstructor
public class PointPolicyQueryDslRepository {


    @Resource(name = TenantDataSourceBeanName.CRM_QUERY_FACTORY)
    private JPAQueryFactory crmQueryFactory;

    public Long countByPointPolicy(){
        return crmQueryFactory.select(pointPolicy.count())
                .from(pointPolicy)
                .from(pointPolicy)
                .fetchOne();
    }
}
