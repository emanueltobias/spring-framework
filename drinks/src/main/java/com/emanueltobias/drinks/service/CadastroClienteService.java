package com.emanueltobias.drinks.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emanueltobias.drinks.model.Cliente;
import com.emanueltobias.drinks.repository.Clientes;
import com.emanueltobias.drinks.service.excepition.CpfOuCnpjClienteJaCadastradoException;

@Service
public class CadastroClienteService {

	@Autowired
	private Clientes clientes;
	
	@Transactional
	public  void salvar(Cliente cliente) {
		Optional<Cliente> clienteExistente = clientes.findBycpfOuCnpj(cliente.getCpfOuCnpjSemFormatacao());
		if(clienteExistente.isPresent()) {
			throw new CpfOuCnpjClienteJaCadastradoException("CPF/CNPJ já cadastrado");
		}
		
		clientes.save(cliente);
	}
	
}
