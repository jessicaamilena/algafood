package com.algaworks.algafood.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.algaworks.algafood.model.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Long>{

	//List<Estado> buscarPorNome();

}
