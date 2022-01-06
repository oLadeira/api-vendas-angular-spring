package com.lucasladeira.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.lucasladeira.entities.Cliente;
import com.lucasladeira.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	
	public List<Cliente> getAll(){
		return clienteRepository.findAll();
	}
	
	public Cliente getById(Integer id) {
		return clienteRepository.findById(id)
		.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	public void save(Cliente cliente) {
		clienteRepository.save(cliente);
	}
	
	public void delete (Integer id) {	
		clienteRepository.findById(id)
		.map(cliente -> {
			clienteRepository.delete(cliente);
			return Void.TYPE;
		})
		.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	public void update (Integer id, Cliente clienteAtualizado) {
		clienteRepository.findById(id)
		.map(cliente -> {
			clienteAtualizado.setId(cliente.getId());
			return clienteRepository.save(clienteAtualizado);
		})
		.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
}
