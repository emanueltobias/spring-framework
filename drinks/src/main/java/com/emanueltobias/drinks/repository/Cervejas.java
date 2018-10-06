package com.emanueltobias.drinks.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emanueltobias.drinks.model.Cerveja;

@Repository
public interface Cervejas extends JpaRepository<Cerveja, Long>{

		public Optional<Cerveja> findBySkuIgnoreCase(String sku);
}
