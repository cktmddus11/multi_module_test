package cals.quintet.crm.endpoint.loyalty.point.service;

import cals.quintet.crm.business.approval.point.model.vo.PointAccrualRequestVo;
import cals.quintet.crm.business.approval.point.service.PointService;
import cals.quintet.crm.endpoint.loyalty.point.model.dto.PointAccrualDto;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author sycha
 * @since 1.0
 */

@RequiredArgsConstructor
@Service
public class PointApiService {

    private final PointService pointService;

    public String test (){
        return "안뇽";
    }

    public PointAccrualDto.Response pointAccrual (PointAccrualDto.Request requestData) {

        LocalDateTime accrualDate = ObjectUtils.isEmpty(requestData.getAccrualDate()) ? LocalDateTime.now() : requestData.getAccrualDate();
        PointAccrualRequestVo requeeRequestVo = PointAccrualRequestVo.builder()
                .pointAmount(requestData.getPointAmount())
                .accrualDt(accrualDate)
                .build();
        Long pointAccrualId = pointService.pointAccrual(requeeRequestVo);
        boolean isSucess = ObjectUtils.isNotEmpty(pointAccrualId);

        return PointAccrualDto.Response.builder()
                .isSuccess(isSucess)
                .build();
    }
}
