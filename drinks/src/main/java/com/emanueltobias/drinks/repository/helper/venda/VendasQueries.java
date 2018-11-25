package com.emanueltobias.drinks.repository.helper.venda;


import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.emanueltobias.drinks.dto.VendaMes;
import com.emanueltobias.drinks.dto.VendaOrigem;
import com.emanueltobias.drinks.model.Venda;
import com.emanueltobias.drinks.repository.filter.VendaFilter;

public interface VendasQueries {

	public Page<Venda> filtrar(VendaFilter filtro, Pageable pageable);
	
	public Venda buscarComItens(Long codigo);
	
	public BigDecimal valorTotalNoAno();
	public BigDecimal valorTotalNoMes();
	public BigDecimal valorTicketMedioNoAno();
	
	public List<VendaMes> totalPorMes();
	public List<VendaOrigem> totalPorOrigem();

}
