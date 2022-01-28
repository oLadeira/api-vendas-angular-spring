package com.lucasladeira.services.exceptions;

public class UsuarioCadastradoException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public UsuarioCadastradoException(String username) {
		super("Usuário com login: " + username + " já cadastrado!");
	}
	
}
