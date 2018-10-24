package com.emanueltobias.drinks.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emanueltobias.drinks.model.Cerveja;
import com.emanueltobias.drinks.repository.helper.cerveja.CervejasQueries;

@Repository
public interface Cervejas extends JpaRepository<Cerveja, Long>, CervejasQueries{

		public Optional<Cerveja> findBySkuIgnoreCase(String sku);
}
