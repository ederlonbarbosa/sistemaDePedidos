package com.ederlonbarbosa.sistemaDePedidos.repositories;

import com.ederlonbarbosa.sistemaDePedidos.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository  extends JpaRepository<Pedido, Long> {
}
