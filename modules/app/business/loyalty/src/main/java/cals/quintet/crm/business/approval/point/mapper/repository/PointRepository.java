package cals.quintet.crm.business.approval.point.mapper.repository;

import cals.quintet.crm.business.domain.entity.PointTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author sycha
 * @since 1.0
 */
public interface PointRepository extends JpaRepository<PointTransaction, Long> {
}
