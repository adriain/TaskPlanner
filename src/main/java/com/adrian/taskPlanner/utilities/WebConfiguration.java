package com.adrian.taskPlanner.utilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@ConfigurationProperties
public class WebConfiguration implements WebMvcConfigurer {
    @Autowired
    private LocaleChangeInterceptor lci;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(lci);
    }
}
