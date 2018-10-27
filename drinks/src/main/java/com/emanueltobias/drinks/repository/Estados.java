package com.emanueltobias.drinks.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emanueltobias.drinks.model.Estado;

@Repository
public interface Estados extends JpaRepository<Estado, Long> {
	
	public Optional<Estado> findByNomeIgnoreCase(String nome);


}
