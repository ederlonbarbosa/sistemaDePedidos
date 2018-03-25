package com.ederlonbarbosa.sistemaDePedidos.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ederlonbarbosa.sistemaDePedidos.domain.Categoria;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

	@RequestMapping(method = RequestMethod.GET)
	public List<Categoria> lista() {
		Categoria informatica = new Categoria(1, "Informática");
		Categoria escritorio = new Categoria(2, "Escritório");

		List<Categoria> categorias = new ArrayList<>();
		categorias.add(informatica);
		categorias.add(escritorio);

		return categorias;
	}

}
