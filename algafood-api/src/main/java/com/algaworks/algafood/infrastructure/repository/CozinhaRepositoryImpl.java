package com.algaworks.algafood.infrastructure.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.model.Cozinha;

@Component
public class CozinhaRepositoryImpl implements CozinhaRepository{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Cozinha> todas(){
		return manager.createQuery("from Cozinha", Cozinha.class).getResultList();
	}
	
	@Override
	public Cozinha porId(Long id) {
		return manager.find(Cozinha.class, id);
	}
	
	@Override
	@Transactional
	public Cozinha adicionar(Cozinha cozinha) {
		return manager.merge(cozinha);
	}
	
	@Override
	@Transactional
	public void remover(Cozinha cozinha) {
		cozinha = porId(cozinha.getId());
		manager.remove(cozinha);
	}
	
}
