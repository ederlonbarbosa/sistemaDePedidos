package com.ederlonbarbosa.sistemaDePedidos.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

public abstract class AbstractResource<T> {

	@Autowired
	private AbstractService<T> service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<T> findById(@PathVariable Long id) {
		return ResponseEntity.ok(service.getById(id));
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> create(@RequestBody T t){
		BaseEntity baseEntity = (BaseEntity) service.create(t);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(baseEntity.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
