package com.emanueltobias.drinks.repository.helper.estilo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.emanueltobias.drinks.model.Cerveja;
import com.emanueltobias.drinks.model.Estilo;
import com.emanueltobias.drinks.repository.filter.EstiloFilter;
import com.emanueltobias.drinks.repository.paginacao.PaginacaoUtil;

public class EstilosImpl implements EstilosQueries {

	@PersistenceContext
	private EntityManager manager;
	
	@Autowired
	private PaginacaoUtil paginacoaUtil;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public Page<Estilo> filtrar(EstiloFilter filtro, Pageable pageable) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Estilo.class);
		
		
		paginacoaUtil.preparar(criteria, pageable);
		adicionaFiltro(filtro, criteria);
		
		return new PageImpl<>(criteria.list(), pageable, total(filtro));
	}
	
	private Long total(EstiloFilter filtro) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Cerveja.class);
		adicionaFiltro(filtro, criteria);
		criteria.setProjection(Projections.rowCount());
		return (Long) criteria.uniqueResult();
	}


	private void adicionaFiltro(EstiloFilter filtro, Criteria criteria) {
		if (filtro != null) {
		
			if (!StringUtils.isEmpty(filtro.getNome())) {
				criteria.add(Restrictions.ilike("nome", filtro.getNome(), MatchMode.ANYWHERE));
			}
			
			if (filtro.getCodigo() != null) {
				criteria.add(Restrictions.eq("codigo", filtro.getClass()));
			}

		}
	}
}
