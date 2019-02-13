package com.emanueltobias.drinks.service.event.venda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.emanueltobias.drinks.model.Cerveja;
import com.emanueltobias.drinks.model.ItemVenda;
import com.emanueltobias.drinks.repository.Cervejas;

@Component
public class VendaListerner {
	
	@Autowired
	private Cervejas cervejas;
	
	@EventListener
	public void vendaEmitida(VendaEvent vendaEvent) {
		for (ItemVenda item : vendaEvent.getVenda().getItens()) {
			Cerveja cerveja = cervejas.getOne(item.getCerveja().getCodigo());
			cerveja.setQuantidadeEstoque(cerveja.getQuantidadeEstoque() - item.getQuantidade());
			cervejas.save(cerveja);
		}
	}

}
