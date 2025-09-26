package com.kozinkaihatsu.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // /images/** のURLを、コンテナ内の /app/images/ にマッピング
        registry.addResourceHandler("/images/**")
        .addResourceLocations("file:/kozinkaihatsu/images/");
    }
}
