package com.emanueltobias.drinks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emanueltobias.drinks.model.Cerveja;
import com.emanueltobias.drinks.repository.Cervejas;

@Service
public class CadastroCervejaService {
	
	@Autowired
	private Cervejas cervejas;
	
	@Transactional
	public void salvar(Cerveja cerveja) {
		
		cervejas.save(cerveja);
	}

}
