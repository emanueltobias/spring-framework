package com.emanueltobias.drinks.service.excepition;

public class NomeEstiloJaCadastradoExcepition extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public NomeEstiloJaCadastradoExcepition(String message) {
		super(message);
	}

}
