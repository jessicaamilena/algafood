package com.algaworks.algafood.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.algaworks.algafood.model.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

	//List<Cidade> consultarPorNome(String nome);
	
}
