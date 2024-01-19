package cals.quintet.crm.endpoint.loyalty.point.controller;

import cals.quintet.crm.endpoint.loyalty.point.model.dto.PointAccrualDto;
import cals.quintet.crm.endpoint.loyalty.point.service.PointApiService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author sycha
 * @since 1.0
 */
@RequiredArgsConstructor
@RequestMapping("/point")
@RestController
public class PointApiController {

    private final PointApiService pointApiService;


    @GetMapping("/test")
    public String test(){
        return pointApiService.test();
    }


    @PostMapping("/pointAccrual")
    public @ResponseBody PointAccrualDto.Response pointAccrual (@RequestHeader(value="Tenant-Code", required = true) String tenantCode,
                                                  @Valid @RequestBody PointAccrualDto.Request requestData){
        // 테넌트 로그 추가
        return pointApiService.pointAccrual(requestData);
    }



}
