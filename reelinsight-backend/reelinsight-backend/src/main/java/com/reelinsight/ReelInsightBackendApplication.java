package com.reelinsight;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ReelInsightBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReelInsightBackendApplication.class, args);
	}

//	@Bean
//	public WebMvcConfigurer corsConfigurer() {
//		return new WebMvcConfigurer() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/**")
//					.allowedOrigins(
//						"http://localhost:5173",
//						"http://localhost:5174",
//						"http://localhost:3000",
//						"http://localhost:8080"
//					)
//					.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH")
//					.allowedHeaders("*")
//					.exposedHeaders("Authorization", "Content-Type")
//					.allowCredentials(true)
//					.maxAge(3600);
//			}
//		};
	//}
}
