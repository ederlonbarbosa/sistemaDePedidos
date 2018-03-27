package com.ederlonbarbosa.sistemaDePedidos.core;

import java.lang.reflect.ParameterizedType;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ederlonbarbosa.sistemaDePedidos.services.exception.ObjectNotFoundException;

public abstract class AbstractService<T> {

	@Autowired
	JpaRepository<T, Long> repository;

	@SuppressWarnings("unchecked")
	public T getById(Long id) {
		Optional<T> object = repository.findById(id);
		return object.orElseThrow(() -> {
			Class<T> classe = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
			return new ObjectNotFoundException(String
					.format("Nenhum registro foi encontrado para o id %s no domínio %s", id, classe.getSimpleName()));
		});
	}

}
