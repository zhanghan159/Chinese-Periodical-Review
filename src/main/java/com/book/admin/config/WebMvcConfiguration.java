package com.book.admin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @Author zhanghan
 * @Description //TODO 配置SpringMVC
 * @Date 16:32 2021/3/4
 * @Param
 * @return
 */
@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
    /**
     * 配置跨域请求
     */
    private static final String[] ALLOWED_ORIGINS = new String[] {
            "http://localhost:63342",
            "http://localhost:3000",
            "http://localhost:8080"
    };

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(ALLOWED_ORIGINS)
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "DELETE", "PUT", "PATCH", "OPTIONS").
                maxAge(3600);
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(0, new MappingJackson2HttpMessageConverter());
    }
}
