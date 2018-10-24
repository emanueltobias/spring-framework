package com.emanueltobias.drinks.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emanueltobias.drinks.model.Estilo;
import com.emanueltobias.drinks.repository.helper.estilo.EstilosQueries;

@Repository
public interface Estilos extends JpaRepository<Estilo, Long>, EstilosQueries {
	
	public Optional<Estilo> findByNomeIgnoreCase(String nome);


}
