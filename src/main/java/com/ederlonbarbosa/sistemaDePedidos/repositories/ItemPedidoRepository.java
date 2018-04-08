package com.ederlonbarbosa.sistemaDePedidos.repositories;

import com.ederlonbarbosa.sistemaDePedidos.domain.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {
}
