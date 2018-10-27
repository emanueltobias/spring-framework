package com.emanueltobias.drinks.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emanueltobias.drinks.model.Cliente;
import com.emanueltobias.drinks.repository.helper.cliente.ClientesQueries;

public interface Clientes extends JpaRepository<Cliente, Long>,  ClientesQueries{

	public Optional<Cliente> findBycpfOuCnpj(String cpfOuCnpj);

}
