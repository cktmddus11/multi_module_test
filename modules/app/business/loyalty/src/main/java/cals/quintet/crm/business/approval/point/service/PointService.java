package cals.quintet.crm.business.approval.point.service;

import cals.quintet.crm.business.approval.point.model.vo.PointAccrualResponseVo;
import cals.quintet.crm.business.approval.point.repository.mapper.crm.PointPolicyQueryDslRepository;
import cals.quintet.crm.business.approval.point.repository.mapper.crm.PointPolicyRepository;
import cals.quintet.crm.business.approval.point.repository.mapper.loycore.PointRepository;
import cals.quintet.crm.business.approval.point.model.vo.PointAccrualRequestVo;
import cals.quintet.crm.business.domain.entity.crm.PointPolicy;
import cals.quintet.crm.business.domain.entity.loycore.PointTransaction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Policy;

/**
 * @author sycha
 * @since 1.0
 */


@RequiredArgsConstructor
@Service
public class PointService {
    private final PointSubService pointSubService;

    private final PointRepository pointRepository;

    private final PointPolicyRepository pointPolicyRepository;


    private final PointPolicyQueryDslRepository pointPolicyQueryDslRepository;

    @Transactional
    public PointAccrualResponseVo pointAccrual (PointAccrualRequestVo requestVo) {
        PointTransaction pointTransaction = PointTransaction.builder()
                .acrlAmt(requestVo.getPointAmount())
                .txnDt(requestVo.getAccrualDt())
                .build();
        PointTransaction insertPntTxn = pointRepository.save(pointTransaction);

       // pointSubService.test(requestVo); // 테스트 완료 후 주석처리

        PointPolicy pointPolicy = PointPolicy.builder()
                .createDate(requestVo.getAccrualDt())
                .pntCnclVldDay(requestVo.getPntCnclVldDay())
                .build();
        PointPolicy insertPntPlcy =pointPolicyRepository.save(pointPolicy);

        return PointAccrualResponseVo.builder()
                .pntTxnId(insertPntTxn.getId().intValue())
                .pntPlcyId(insertPntPlcy.getId().intValue())
                .build();

    }

    public Long countByPointPolicy(){
        return pointPolicyQueryDslRepository.countByPointPolicy();
    }
}
