package com.lucasladeira.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.lucasladeira.entities.Cliente;
import com.lucasladeira.entities.ServicoPrestado;
import com.lucasladeira.repositories.ClienteRepository;
import com.lucasladeira.repositories.ServicoPrestadoRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ServicoPrestadoRepository servicoPrestadoRepository;
	
	@Override
	public void run(String... args) throws Exception {

		Cliente c1 = new Cliente(null, "Pedro Henrique", "17485039016", null);
		Cliente c2 = new Cliente(null, "Gustavo Silva", "38467179082", null);
		Cliente c3 =  new Cliente(null, "Lucas Ladeira", "34164018089", null);
		Cliente c4 =  new Cliente(null, "Fabor Ducas", "08289011040", null);
		Cliente c5 =  new Cliente(null, "Hesamyos Saofo", "57282939055", null);
		Cliente c6 =  new Cliente(null, "Erpabul Erpabul", "13818710031", null);
		Cliente c7 =  new Cliente(null, "Elwus Fesoco", "81859970044", null);
		Cliente c8 =  new Cliente(null, "Encefica Tuhus", "41980528080", null);
		Cliente c9 =  new Cliente(null, "Laulu Fiuar", "56101549011", null);
		Cliente c10 =  new Cliente(null, "Huveson Flopa", "36416865041", null);
		
		clienteRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10));
		
	}
	
	
}
