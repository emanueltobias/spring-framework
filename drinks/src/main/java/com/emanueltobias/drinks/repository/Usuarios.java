package com.emanueltobias.drinks.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emanueltobias.drinks.model.Usuario;

public interface Usuarios extends JpaRepository<Usuario, Long> {

	public Optional<Usuario> findByEmail(String email);

}