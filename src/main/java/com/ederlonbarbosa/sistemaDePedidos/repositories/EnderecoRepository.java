package com.ederlonbarbosa.sistemaDePedidos.repositories;

import com.ederlonbarbosa.sistemaDePedidos.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
