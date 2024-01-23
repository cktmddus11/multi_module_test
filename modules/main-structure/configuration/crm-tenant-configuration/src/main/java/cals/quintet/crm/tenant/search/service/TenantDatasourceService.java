package cals.quintet.crm.tenant.search.service;


import cals.quintet.crm.tenant.search.model.vo.TenantDatasourceVo;
import cals.quintet.crm.tenant.search.repository.template.TenantDatasourceTemplate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author sycha
 * @since 1.0
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class TenantDatasourceService {
    private final TenantDatasourceTemplate tenantDatasourceTemplate;


    public Map<String, TenantDatasourceVo> searchTenantDatasource () {
        Map<String, TenantDatasourceVo> tenantDatasourceVoMap = new HashMap<>();
        try {
            List<TenantDatasourceVo> tenantDatasource = tenantDatasourceTemplate.getTenantDatasource();
            tenantDatasourceVoMap = tenantDatasource.stream()
                    .collect(Collectors.toMap(TenantDatasourceVo::getTenantCode, c -> c));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return tenantDatasourceVoMap;
    }


}
