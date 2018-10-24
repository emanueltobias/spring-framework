package com.emanueltobias.drinks.repository.helper.cerveja;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.emanueltobias.drinks.model.Cerveja;
import com.emanueltobias.drinks.repository.filter.CervejaFilter;

public interface CervejasQueries {

	public Page<Cerveja> filtrar(CervejaFilter filtro, Pageable pageable);
	
}
