package com.multipurpose.web.config;

import com.multipurpose.web.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .order(1)
                .addPathPatterns("/**")
                .excludePathPatterns("/user/joins","/home", "/login/logins","/userC/id","/userC/pwd","/userC/call",
                        "/userU/pwd","/userU/call","/error","/error-page/**",


                        "/joinFunction.js","/updateFunction.js","/deleteFunction.js","/boardWrite.js","/boardUpdate.js","/boardDelete.js",
                        "/API/**","/JC/**","/loginAPI/**","/boardAPI/**");
    }
}
/**
 * API 설계를 위해서 API 컨트롤러는 인터셉터에서 제외
 * "/API/**","/JC/**"   <= API 매핑 경로
 * loginAPI
 *
 * */