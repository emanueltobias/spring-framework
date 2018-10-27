package com.emanueltobias.drinks.service.excepition;

public class CidadeJaCadastradaException extends RuntimeException {

private static final long serialVersionUID = 1L;
	
	public CidadeJaCadastradaException(String message) {
		super(message);
	}
}
