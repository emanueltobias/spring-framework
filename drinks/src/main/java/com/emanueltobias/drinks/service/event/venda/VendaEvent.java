package com.emanueltobias.drinks.service.event.venda;

import com.emanueltobias.drinks.model.Venda;

public class VendaEvent {

	private Venda venda;
	
	public  VendaEvent(Venda venda) {
		this.venda = venda;
	}
	
	public Venda getVenda() {
		return venda;
	}
}
