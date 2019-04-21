package com.flex.dividas.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	/*
	 * @Override public void addCorsMappings(CorsRegistry registry) {
	 * registry.addMapping("/**").allowedOrigins("*"); }
	 */

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/v1/**").allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE");
	}
}