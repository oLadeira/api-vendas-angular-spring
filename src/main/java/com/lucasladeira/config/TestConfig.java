package com.lucasladeira.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.lucasladeira.entities.Cliente;
import com.lucasladeira.repositories.ClienteRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	ClienteRepository clienteRepository;
	
	@Override
	public void run(String... args) throws Exception {

		Cliente c1 = new Cliente(null, "Pedro Henrique", "33333333333", null);
		
		clienteRepository.saveAll(Arrays.asList(c1));
	}
	
	
}
