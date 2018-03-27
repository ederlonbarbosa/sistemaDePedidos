package com.ederlonbarbosa.sistemaDePedidos.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public abstract class AbstractResource<T> {

	@Autowired
	private AbstractService<T> service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<T> findById(@PathVariable Long id) {
		return ResponseEntity.ok(service.getById(id));
	}
}
