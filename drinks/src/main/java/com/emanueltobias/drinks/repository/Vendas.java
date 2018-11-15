package com.emanueltobias.drinks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emanueltobias.drinks.model.Venda;
import com.emanueltobias.drinks.repository.helper.venda.VendasQueries;

public interface Vendas extends JpaRepository<Venda, Long>, VendasQueries {

};