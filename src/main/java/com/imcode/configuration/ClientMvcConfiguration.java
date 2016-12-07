package com.imcode.configuration;

import imcode.services.argumentresolver.IvisServiceArgumentResolver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.List;

/**
 * Created by ruslan on 07.12.16.
 */
@Configuration
public class ClientMvcConfiguration extends WebMvcConfigurerAdapter {

    @Value("${spring.mvc.view.prefix}")
    private String viewPrefix;

    @Value("${spring.mvc.view.suffix}")
    private String viewSuffix;

    @Bean
    public HandlerMethodArgumentResolver ivisServiceArgumentResolver() {
        return new IvisServiceArgumentResolver();
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(ivisServiceArgumentResolver());
    }

    @Override
    public void configureDefaultServletHandling(
            DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix(viewPrefix);
        resolver.setSuffix(viewSuffix);
        return resolver;
    }
}
