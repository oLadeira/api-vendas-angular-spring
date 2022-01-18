package com.lucasladeira.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.lucasladeira.dto.ServicoPrestadoDTO;
import com.lucasladeira.entities.Cliente;
import com.lucasladeira.entities.ServicoPrestado;
import com.lucasladeira.repositories.ClienteRepository;
import com.lucasladeira.repositories.ServicoPrestadoRepository;

@Service
public class ServicoPrestadoService {

	@Autowired
	private ServicoPrestadoRepository servicoPrestadoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public void salvar(ServicoPrestado servicoPrestado) {
		clienteRepository.findById(servicoPrestado.getCliente().getId())
		.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
		servicoPrestadoRepository.save(servicoPrestado);
	}
	
	public List<ServicoPrestado> procurar (String nome, Integer mes){
		return servicoPrestadoRepository.findByNomeClienteAndMes("%" + nome + "%", mes);
	}
	
	public ServicoPrestado procurarPorId(Integer id) {
		return servicoPrestadoRepository.findById(id).get();
	}
	
	public ServicoPrestado fromDTO(ServicoPrestadoDTO dto) {		
		LocalDate date = LocalDate.parse(dto.getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));	
		//Optional<Cliente>cliente = clienteRepository.findById(dto.getIdCliente());
		
		Optional<Cliente> cliente = clienteRepository.findById(dto.getIdCliente());	
		cliente.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cliente Inexistente!"));
		
		ServicoPrestado servicoPrestado = new ServicoPrestado();
		
		servicoPrestado.setDescricao(dto.getDescricao());
		
		//dto.getValor().replaceAll(",", ".");
		//Double.parseDouble( dto.getValor().replaceAll(",", ".") )
		servicoPrestado.setValor( Double.parseDouble(dto.getValor()) );
		
		servicoPrestado.setData(date);
		servicoPrestado.setCliente(cliente.get());
		return servicoPrestado;
	}
}
