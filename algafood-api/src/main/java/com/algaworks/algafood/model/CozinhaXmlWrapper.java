package com.algaworks.algafood.model;

import java.util.List;
import lombok.Data;
import lombok.NonNull;

@Data
public class CozinhaXmlWrapper {

	@NonNull
	private List<Cozinha> cozinhas;
	
}
