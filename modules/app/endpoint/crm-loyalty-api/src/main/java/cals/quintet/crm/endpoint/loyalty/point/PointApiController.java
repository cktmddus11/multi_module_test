package cals.quintet.crm.endpoint.loyalty.point;

import cals.quintet.crm.business.approval.point.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sycha
 * @since 1.0
 */
@RestController
public class PointApiController {

    @Autowired
    private PointService pointService;

    @GetMapping("/")
    public String test(){
        String accrual = pointService.accrual();
        return accrual;
    }
}
