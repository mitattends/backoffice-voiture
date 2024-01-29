package com.example.backofficeVoiture.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CrossOriginConfiguration implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("https://glistening-conkies-fbbf64.netlify.app", "*")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
    }
}
