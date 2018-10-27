package com.emanueltobias.drinks.service.excepition;

public class CpfOuCnpjClienteJaCadastradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public CpfOuCnpjClienteJaCadastradoException(String message) {
		super(message);
	}
}
