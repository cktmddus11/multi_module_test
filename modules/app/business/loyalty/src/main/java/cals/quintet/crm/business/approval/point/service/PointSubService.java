package cals.quintet.crm.business.approval.point.service;

import cals.quintet.crm.business.approval.point.model.vo.PointAccrualRequestVo;
import cals.quintet.crm.business.approval.point.repository.mapper.crm.PointPolicyRepository;
import cals.quintet.crm.business.approval.point.repository.mapper.loycore.PointRepository;
import cals.quintet.crm.business.domain.entity.loycore.PointTransaction;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author sycha
 * @since 1.0
 */
@Slf4j

@RequiredArgsConstructor
@Service
public class PointSubService {


    private final PointRepository pointRepository;

    @Transactional(propagation =Propagation.REQUIRES_NEW)
    public void test (PointAccrualRequestVo requestVo) {
        PointTransaction pointTransaction = PointTransaction.builder()
                .acrlAmt(requestVo.getPointAmount())
                .txnDt(requestVo.getAccrualDt())
                .build();
        PointTransaction insertPntTxn = pointRepository.save(pointTransaction);

        log.info("sub servicr insert : " + insertPntTxn.getId());

    }

}

