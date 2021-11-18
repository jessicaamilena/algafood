package com.algaworks.algafood.domain.repository;

import java.util.List;
import com.algaworks.algafood.model.Restaurante;

public interface RestauranteRepository {

	List<Restaurante> listar();
	Restaurante buscar(Long id);
	Restaurante salvar(Restaurante restaurante);
	void remover(Restaurante restaurante);
}
