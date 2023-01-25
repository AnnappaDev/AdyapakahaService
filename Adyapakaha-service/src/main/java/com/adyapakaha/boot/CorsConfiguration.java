package com.adyapakaha.boot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration {
private static final String GET = "GET";
private static final String POST = "POST";
private static final String PUT = "PUT";
private static final String DELETE = "DELETE";

	@Bean
	public WebMvcConfigurer corsConfigurer () {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				// TODO Auto-generated method stub
				registry.addMapping("/**")
				.allowedOrigins("http://localhost:8100")
				.allowedMethods(GET, PUT, POST, DELETE)
				.allowedHeaders("*")
				.allowedOriginPatterns("*")
				.allowCredentials(true);
//				WebMvcConfigurer.super.addCorsMappings(registry);
			}
		};
	}
}
