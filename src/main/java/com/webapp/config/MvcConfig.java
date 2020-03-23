package com.webapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer
{

    @Override
    public void addViewControllers(ViewControllerRegistry registry)
    {
        registry.addViewController("/login").setViewName("login");
//        registry.addViewController("/hello").setViewName("hello");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry)
    {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
//        registry.addResourceHandler("/static/css/**").addResourceLocations("classpath:/static/");
//        registry.addResourceHandler("/static/js/**").addResourceLocations("classpath:/static/");
    }
}
