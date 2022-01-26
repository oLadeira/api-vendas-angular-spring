package com.lucasladeira.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;


@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter{
	
	/* classe responsavel em configurar acessos aos recursos da api
	 * no metodo configure estou mapeando qual ROLE é permitido acessar qual URL 
	 * exemplo ROLE USER pode acessar o recurso no endereco /api/clientes/qualquercoisa*/
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		//.antMatchers("/api/clientes/**").hasRole("USER") //permitindo somente USER
		.antMatchers("/api/usuarios").permitAll() //permitindo todos
		.antMatchers("/h2-console/**").permitAll()
		.antMatchers("/api/cliente/**", "/api/servicos-prestados/**").authenticated()
		.anyRequest().denyAll();//recusar qualquer outra requisicao
	}
}
