package cals.quintet.crm.endpoint.loyalty.point;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sycha
 * @since 1.0
 */
@RestController
public class PointApiController {

    @GetMapping("/")
    public String test(){
        return "안뇽";
    }
}
