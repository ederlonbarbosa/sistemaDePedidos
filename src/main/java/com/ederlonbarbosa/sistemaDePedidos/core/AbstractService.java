package com.ederlonbarbosa.sistemaDePedidos.core;

import com.ederlonbarbosa.sistemaDePedidos.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.reflect.ParameterizedType;
import java.util.Optional;

public abstract class AbstractService<T> {

	@Autowired
	private JpaRepository<T, Long> repository;

	@SuppressWarnings("unchecked")
	public T getById(Long id) {
		Optional<T> object = repository.findById(id);
		return object.orElseThrow(() -> {
			Class<T> classe = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
			return new ObjectNotFoundException(String
					.format("Nenhum registro foi encontrado para o id %s no domínio %s", id, classe.getSimpleName()));
		});
	}

	public T create(T t){
		T object = null;
		try{
			object = repository.save(t);
		}catch (Exception e){
			new Exception("Erro ao tentar salvar");
		}
		return object;
	}
}
