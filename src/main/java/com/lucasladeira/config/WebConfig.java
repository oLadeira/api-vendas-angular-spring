package com.lucasladeira.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class WebConfig {

	@Bean
	public FilterRegistrationBean<CorsFilter> corsFilterRegistrationBean(){
		
		List<String> all = Arrays.asList("*"); //asterisco permite tudo
		
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowedOriginPatterns(all); //enderecos permitidos exemplo ='localhost:8080'
		corsConfiguration.setAllowedHeaders(all);
		corsConfiguration.setAllowedMethods(all); //metodos permitidos exemplo ='GET', 'POST' etc		
		corsConfiguration.setAllowCredentials(true);
		
		
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", corsConfiguration); //com esta url eu vou ativar o corsConfiguration criado acima
		
		CorsFilter corsFilter = new CorsFilter((CorsConfigurationSource) source);
		FilterRegistrationBean<CorsFilter> filter = new FilterRegistrationBean<>(corsFilter);
		filter.setOrder(Ordered.HIGHEST_PRECEDENCE);
		
		return filter;
	}
	
}
