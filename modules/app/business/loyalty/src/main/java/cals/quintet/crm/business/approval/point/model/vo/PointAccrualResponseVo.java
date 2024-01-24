package cals.quintet.crm.business.approval.point.model.vo;

import lombok.Builder;
import lombok.Getter;

/**
 * @author sycha
 * @since 1.0
 */

@Getter
@Builder
public class PointAccrualResponseVo {

    private Integer pntTxnId;
    private Integer pntPlcyId;
}
