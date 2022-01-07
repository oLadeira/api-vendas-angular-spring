package com.lucasladeira.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import com.lucasladeira.controllers.exceptions.ApiErrors;

@RestControllerAdvice
public class ApplicationControllerAdvice {

	@ExceptionHandler(MethodArgumentNotValidException.class) //interceptando o erro
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ApiErrors handleValidationErrors(MethodArgumentNotValidException ex) {
		BindingResult bindingResult = ex.getBindingResult(); //instanciando objeto com os erros
		List<String> messages = bindingResult.getAllErrors() //criando uma lista com os erros
		.stream()
		.map(objectError -> objectError.getDefaultMessage()) //pegando as mensagens dos erros
		.collect(Collectors.toList()); //transformando em lista
		return new ApiErrors(messages); //retornando o objeto que criamos ApiErrors com o array de mensagens dos erros
	}
	
	@ExceptionHandler(ResponseStatusException.class)
	public ResponseEntity handleResponseStatusException(ResponseStatusException ex) {
		String errorMessage = ex.getMessage();
		HttpStatus status = ex.getStatus();
		ApiErrors apiErrors = new ApiErrors(errorMessage);
		return new ResponseEntity(apiErrors, status);
	}
}
