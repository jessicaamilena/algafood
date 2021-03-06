package com.algaworks.algafood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.repository.EstadoRepository;
import com.algaworks.algafood.model.Estado;

@Service
public class CadastroEstadoService {
		
		@Autowired
		private EstadoRepository estadoRepository;
		
		public Estado salvar(Estado estado) {
			return estadoRepository.save(estado);
		}
		
		public void excluir(Long estadoId) {
			try {
				estadoRepository.deleteById(estadoId);
			} catch (EmptyResultDataAccessException e) {
				throw new EntidadeNaoEncontradaException(
					String.format("Não existe um cadastro de cozinha com cód. %d", estadoId));
			}catch (DataIntegrityViolationException e) {
				throw new EntidadeEmUsoException(
					String.format("Cozinha de cód. %d não pode ser removida pois está em uso", estadoId));
			}
		}
}
