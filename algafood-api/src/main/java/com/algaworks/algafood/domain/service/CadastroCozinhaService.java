package com.algaworks.algafood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.model.Cozinha;

@Service
public class CadastroCozinhaService {
		
		@Autowired
		private CozinhaRepository cozinhaRepository;
		
		public Cozinha adicionar(Cozinha cozinha) {
			return cozinhaRepository.adicionar(cozinha);
		}
		
		public void excluir(Long cozinhaId) {
			try {
				cozinhaRepository.remover(cozinhaId);
			} catch (EmptyResultDataAccessException e) {
				throw new EntidadeNaoEncontradaException(
					String.format("Não existe um cadastro de cozinha com cód. %d", cozinhaId));
			}catch (DataIntegrityViolationException e) {
				throw new EntidadeEmUsoException(
					String.format("Cozinha de cód. %d não pode ser removida pois está em uso", cozinhaId));
			}
		}
}
