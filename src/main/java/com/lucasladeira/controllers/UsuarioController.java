package com.lucasladeira.controllers;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lucasladeira.entities.Usuario;
import com.lucasladeira.services.UsuarioService;
import com.lucasladeira.services.exceptions.UsuarioCadastradoException;

@RestControllerAdvice
@RequestMapping("/api/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping
	public ResponseEntity<Void> save (@RequestBody @Valid Usuario usuario){
		try {
			Usuario user = usuarioService.save(usuario);
			URI uri = ServletUriComponentsBuilder
					.fromCurrentRequestUri()
					.path("/{id}")
					.buildAndExpand(user.getId())
					.toUri();
			return ResponseEntity.created(uri).build();
		}catch(UsuarioCadastradoException ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
		}		
	}
	
}
