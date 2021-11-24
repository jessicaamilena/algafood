package com.algaworks.algafood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.repository.RestauranteRepository;
import com.algaworks.algafood.model.Cozinha;
import com.algaworks.algafood.model.Restaurante;

@Service
public class CadastroRestauranteService {
		
		@Autowired
		private RestauranteRepository restauranteRepository;
		
		@Autowired
		private CozinhaRepository cozinhaRepository;
		
		
		public Restaurante salvar(Restaurante restaurante) {
			Long cozinhaId = restaurante.getCozinha().getId();
			Cozinha cozinha = cozinhaRepository.buscar(cozinhaId);
			
			if (cozinha == null) {
				throw new EntidadeNaoEncontradaException(String.format("Não existe o cadastro de cozinha com cód. %d", cozinhaId));
			}
			
			restaurante.setCozinha(cozinha);
			
			return restauranteRepository.salvar(restaurante);
		}
		
		public void excluir(Long restauranteId) {
			try {
				restauranteRepository.remover(restauranteId);
			} catch (EmptyResultDataAccessException e) {
				throw new EntidadeNaoEncontradaException(
					String.format("Não existe um cadastro de cozinha com cód. %d", restauranteId));
			}catch (DataIntegrityViolationException e) {
				throw new EntidadeEmUsoException(
					String.format("Cozinha de cód. %d não pode ser removida pois está em uso", restauranteId));
			}
		}
}
