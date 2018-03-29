package com.ederlonbarbosa.sistemaDePedidos.resources;

import com.ederlonbarbosa.sistemaDePedidos.core.AbstractResource;
import com.ederlonbarbosa.sistemaDePedidos.domain.Cliente;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource extends AbstractResource<Cliente> {
}
