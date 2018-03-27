package com.ederlonbarbosa.sistemaDePedidos.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ederlonbarbosa.sistemaDePedidos.services.exception.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExcpetionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandarError> objectNotFound(ObjectNotFoundException objectNotFoundException,
			HttpServletRequest httpServletRequest) {

		StandarError standarError = new StandarError(HttpStatus.NOT_FOUND.value(), objectNotFoundException.getMessage(),
				System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standarError);

	}

}
