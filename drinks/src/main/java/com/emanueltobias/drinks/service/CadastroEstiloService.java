package com.emanueltobias.drinks.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emanueltobias.drinks.model.Estilo;
import com.emanueltobias.drinks.repository.Estilos;
import com.emanueltobias.drinks.service.excepition.NomeEstiloJaCadastradoExcepition;

@Service
public class CadastroEstiloService {
	
	@Autowired
	private Estilos estilos;
	
	@Transactional
	public Estilo salvar(Estilo estilo) {
		Optional<Estilo> estiloOptional = estilos.findByNomeIgnoreCase(estilo.getNome());
		if (estiloOptional.isPresent()) {
			throw new NomeEstiloJaCadastradoExcepition("Nome do estilo já cadastrado");
		}
		return estilos.saveAndFlush(estilo);
	}

}
