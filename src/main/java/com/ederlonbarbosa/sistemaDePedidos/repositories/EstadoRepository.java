package com.ederlonbarbosa.sistemaDePedidos.repositories;

import com.ederlonbarbosa.sistemaDePedidos.domain.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

}
