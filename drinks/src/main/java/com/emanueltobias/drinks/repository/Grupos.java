package com.emanueltobias.drinks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emanueltobias.drinks.model.Grupo;

public interface Grupos extends JpaRepository<Grupo, Long> {

}