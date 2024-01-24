package cals.quintet.crm.business.approval.point.repository.mapper.crm;

import cals.quintet.crm.business.domain.entity.crm.PointPolicy;
import cals.quintet.crm.business.domain.entity.loycore.PointTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author sycha
 * @since 1.0
 */
public interface PointPolicyRepository extends JpaRepository<PointPolicy, Long> {
}
