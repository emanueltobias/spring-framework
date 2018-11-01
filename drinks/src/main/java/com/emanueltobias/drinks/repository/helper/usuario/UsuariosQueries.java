package com.emanueltobias.drinks.repository.helper.usuario;

import java.util.List;
import java.util.Optional;

import com.emanueltobias.drinks.model.Usuario;

public interface UsuariosQueries {

	public Optional<Usuario> porEmailEAtivo(String email);
	
	public List<String> permissoes(Usuario usuario);
	
}