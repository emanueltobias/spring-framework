package com.emanueltobias.drinks.service.event.cerveja;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.emanueltobias.drinks.storage.local.FotoStorage;

@Component
public class CervejaListener {
	
	@Autowired
	private FotoStorage fotoStorage;
	
	@EventListener(condition = "#event.temFoto() and #evento.novaFoto")
	public void cervejaSalva(CervejaSalvaEvent event) {
		fotoStorage.salvar(event.getCerveja().getFoto());
	}

}
