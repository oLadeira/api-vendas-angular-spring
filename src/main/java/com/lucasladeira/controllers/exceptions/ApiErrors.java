package com.lucasladeira.controllers.exceptions;

import java.util.Arrays;
import java.util.List;

public class ApiErrors {

	private List<String> errors;

	public ApiErrors(List<String> errors) {
		this.errors = errors;
	}
	
	public ApiErrors(String message) { //pega uma string e transforma em array
		this.errors = Arrays.asList(message);
	}
	
	public List<String> getErrors() {
		return errors;
	}
}
