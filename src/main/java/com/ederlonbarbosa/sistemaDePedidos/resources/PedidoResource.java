package com.ederlonbarbosa.sistemaDePedidos.resources;

import com.ederlonbarbosa.sistemaDePedidos.core.AbstractResource;
import com.ederlonbarbosa.sistemaDePedidos.domain.Pedido;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource extends AbstractResource<Pedido> {
}
