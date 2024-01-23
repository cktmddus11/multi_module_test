package cals.quintet.crm.business.approval.point.service;

import cals.quintet.crm.business.approval.point.repository.mapper.PointRepository;
import cals.quintet.crm.business.approval.point.model.vo.PointAccrualRequestVo;
import cals.quintet.crm.business.domain.entity.PointTransaction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author sycha
 * @since 1.0
 */


@RequiredArgsConstructor
@Service
public class PointService {
    private final PointRepository pointRepository;

    public Long pointAccrual (PointAccrualRequestVo requestVo) {
        PointTransaction pointTransaction = PointTransaction.builder()
                .acrlAmt(requestVo.getPointAmount())
                .txnDt(requestVo.getAccrualDt())
                .build();
        PointTransaction insertPntTxn = pointRepository.save(pointTransaction);

        return insertPntTxn.getId();
    }
}
