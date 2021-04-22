package com.book.admin.config;

import com.book.admin.filter.LoginFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName FilterConfig
 * @Description TODO
 * @Author zhanghan.a
 * Data 2021/4/22 20:58
 */
@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean registFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new LoginFilter());
        registration.addUrlPatterns("*.html");
        registration.setName("LoginFilter");
        registration.setOrder(1);
        return registration;
    }
}
