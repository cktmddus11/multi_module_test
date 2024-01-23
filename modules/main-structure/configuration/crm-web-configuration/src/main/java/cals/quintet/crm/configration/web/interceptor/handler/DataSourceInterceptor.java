package cals.quintet.crm.configration.web.interceptor.handler;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import maestro.quintet.crm.data.datasource.TenantDatabase;
import maestro.quintet.crm.data.datasource.TenantRoutingDataSourceContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @author sycha
 * @since 1.0
 */
@Slf4j
@Component
public class DataSourceInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle (HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("============= dataSource interceptor Call...  ==============");


        String tenantCode = request.getHeader("Tenant-Code");

         if (TenantDatabase.TENANTA.toString().equalsIgnoreCase(tenantCode))
            TenantRoutingDataSourceContextHolder.set(TenantDatabase.TENANTA);
        else
            TenantRoutingDataSourceContextHolder.set(TenantDatabase.TENANTB);

        log.info("============= dataSource interceptor End...  ==============");


        return HandlerInterceptor.super.preHandle(request, response, handler);
    }


}
