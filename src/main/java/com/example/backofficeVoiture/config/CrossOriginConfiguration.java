package com.example.backofficeVoiture.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class CrossOriginConfiguration implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry
                .addMapping("/**")
                .allowedMethods("*")
                .allowedOrigins("*")
                .allowedHeaders("*");
    }
}
