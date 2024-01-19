package cals.quintet.crm.configration.web.interceptor;

import cals.quintet.crm.configration.web.interceptor.handler.DataSourceInterceptor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author sycha
 * @since 1.0
 */
@Slf4j
@RequiredArgsConstructor
@Configuration
public class WebConfig implements WebMvcConfigurer {

    private  final DataSourceInterceptor dataSourceInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        log.info("============= interceptor Setting...  ==============");

        registry.addInterceptor(dataSourceInterceptor).addPathPatterns("/**");
        WebMvcConfigurer.super.addInterceptors(registry);

        log.info("============= interceptor Complete...  ==============");


    }
}