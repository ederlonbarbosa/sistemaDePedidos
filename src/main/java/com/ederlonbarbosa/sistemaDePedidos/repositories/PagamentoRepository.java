package com.ederlonbarbosa.sistemaDePedidos.repositories;

import com.ederlonbarbosa.sistemaDePedidos.domain.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
}
