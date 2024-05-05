package com.CS157AProject.CourseBrief.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebSecurityConfig implements WebMvcConfigurer{
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
              .allowedOrigins("http://localhost:5173") // Adjust the origin to match your React app's origin
              .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS")
              .allowCredentials(true).maxAge(3600);
    }

}
