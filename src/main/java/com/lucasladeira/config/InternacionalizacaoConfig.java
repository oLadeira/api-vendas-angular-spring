package com.lucasladeira.config;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class InternacionalizacaoConfig {

	//definindo o arquivo de mensagens, a fonte
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:messages"); //resources/messages.properties
		messageSource.setDefaultEncoding("ISO-8859-1"); //
		messageSource.setDefaultLocale(Locale.getDefault()); //recuperando o pais do usuario pelo SO
		return messageSource;
	}
	
	//definindo o validator passando o messageSource
	@Bean
	public LocalValidatorFactoryBean validatorFactoryBean() {
		LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
		bean.setValidationMessageSource(messageSource());
		return bean;
	}
	
}
