package com.ederlonbarbosa.sistemaDePedidos.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ederlonbarbosa.sistemaDePedidos.core.AbstractResource;
import com.ederlonbarbosa.sistemaDePedidos.domain.Categoria;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource extends AbstractResource<Categoria> {

}
