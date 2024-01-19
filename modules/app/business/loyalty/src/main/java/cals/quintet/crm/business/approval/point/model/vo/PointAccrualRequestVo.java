package cals.quintet.crm.business.approval.point.model.vo;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * @author sycha
 * @since 1.0
 */
@Getter
@Builder
public class PointAccrualRequestVo {

    private int pointAmount;
    private LocalDateTime accrualDt;

}
