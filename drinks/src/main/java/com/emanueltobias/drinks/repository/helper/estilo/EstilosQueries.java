package com.emanueltobias.drinks.repository.helper.estilo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.emanueltobias.drinks.model.Estilo;
import com.emanueltobias.drinks.repository.filter.EstiloFilter;

public interface EstilosQueries {

	public Page<Estilo> filtrar(EstiloFilter filtro, Pageable pageable);
	
}
