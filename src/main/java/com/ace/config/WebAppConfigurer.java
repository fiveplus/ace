package com.ace.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.ace.interceptor.AdminInterceptor;

@Configuration
public class WebAppConfigurer extends WebMvcConfigurerAdapter{
	@Bean
	AdminInterceptor adminInterceptor(){
		return new AdminInterceptor();
	}
	
	public void addInterceptors(InterceptorRegistry registry) {
		// 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
		registry.addInterceptor(adminInterceptor()).addPathPatterns("/admin/**");
		super.addInterceptors(registry);
	}
	
}
