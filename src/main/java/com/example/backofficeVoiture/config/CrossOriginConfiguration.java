package com.example.backofficeVoiture.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CrossOriginConfiguration implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("https://glistening-conkies-fbbf64.netlify.app", "http://localhost:3000", "http://localhost:8100")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
    }
}
