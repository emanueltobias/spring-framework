package com.emanueltobias.drinks.service;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emanueltobias.drinks.model.Cerveja;
import com.emanueltobias.drinks.repository.Cervejas;
import com.emanueltobias.drinks.service.excepition.ImpossivelExcluirEntidadeException;
import com.emanueltobias.drinks.storage.FotoStorage;

@Service
public class CadastroCervejaService {

	@Autowired
	private Cervejas cervejas;
	
	@Autowired
	private FotoStorage fotoStorage;

	@Transactional
	public void salvar(Cerveja cerveja) {
		cervejas.save(cerveja);

	}

	@Transactional
	public void excluir(Cerveja cerveja) {
		try {
			String foto = cerveja.getFoto();
			cervejas.delete(cerveja);
			cervejas.flush();
			fotoStorage.excluir(foto);
		} catch (PersistenceException e) {
			throw new ImpossivelExcluirEntidadeException("Impossível apagar cerveja. Já foi utilizada em alguma venda.");
		}

	}

}
