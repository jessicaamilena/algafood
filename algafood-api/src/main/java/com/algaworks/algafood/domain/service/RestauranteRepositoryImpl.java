package com.algaworks.algafood.domain.service;

import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import com.algaworks.algafood.domain.repository.RestauranteRepositoryQueries;
import com.algaworks.algafood.model.Restaurante;

@Repository
public class RestauranteRepositoryImpl implements RestauranteRepositoryQueries {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Restaurante> find(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal){
		String jpql = "from Restaurante where nome like :nome and taxaFrete between :taxaFrete and :taxaFinal";
		
		return manager.createQuery(jpql, Restaurante.class).setParameter("nome", "%" + nome + "%").setParameter("taxaInicial", taxaFreteInicial)
				.setParameter("taxaFinal", taxaFreteFinal).getResultList();
	}
}
