package com.emanueltobias.drinks.controller.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.emanueltobias.drinks.service.excepition.NomeEstiloJaCadastradoExcepition;

@ControllerAdvice
public class ControllerAdviceExeptionHandler {
	
	@ExceptionHandler(NomeEstiloJaCadastradoExcepition.class)
	public ResponseEntity<String> handleNomeEstiloJaCadastradoExepition(NomeEstiloJaCadastradoExcepition e) {
		return ResponseEntity.badRequest().body(e.getMessage());
	}

}
