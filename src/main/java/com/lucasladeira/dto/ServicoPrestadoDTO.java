package com.lucasladeira.dto;

import java.io.Serializable;


public class ServicoPrestadoDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String descricao;
	private String valor;
	private String data;
	private Integer idCliente;
	
	
	public ServicoPrestadoDTO() {
		super();
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getValor() {
		return valor;
	}


	public void setValor(String valor) {
		this.valor = valor;
	}


	public String getData() {
		return data;
	}


	public void setData(String data) {
		this.data = data;
	}


	public Integer getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	
	
}
