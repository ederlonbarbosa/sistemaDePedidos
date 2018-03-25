package com.ederlonbarbosa.sistemaDePedidos.dml.impl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ederlonbarbosa.sistemaDePedidos.dml.PopulaDados;
import com.ederlonbarbosa.sistemaDePedidos.domain.Categoria;
import com.ederlonbarbosa.sistemaDePedidos.repositories.CategoriaRepository;

@Service
public class CategoriaDML implements PopulaDados {

	@Autowired
	CategoriaRepository categoriaRepository;

	@Override
	public void popularDados() {

		Categoria informatica = new Categoria("Informática");
		Categoria escritorio = new Categoria("Escritório");

		categoriaRepository.saveAll(Arrays.asList(informatica, escritorio));
	}

}
