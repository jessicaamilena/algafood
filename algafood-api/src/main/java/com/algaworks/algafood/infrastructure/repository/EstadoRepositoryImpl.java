package com.algaworks.algafood.infrastructure.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import com.algaworks.algafood.domain.repository.EstadoRepository;
import com.algaworks.algafood.model.Estado;

@Component
public class EstadoRepositoryImpl implements EstadoRepository{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Estado> listar(){
		return manager.createQuery("from Estado", Estado.class).getResultList();
	}
	
	@Override
	public Estado buscar(Long id) {
		return manager.find(Estado.class, id);
	}
	
	@Override
	@Transactional
	public Estado salvar(Estado estado) {
		return manager.merge(estado);
	}
	
	@Override
	@Transactional
	public void remover(Long id) {
		Estado estado = buscar(id);
		
		if(estado == null) {
			throw new EmptyResultDataAccessException(1);
		}
		manager.remove(estado);
	}
	
}
