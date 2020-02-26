/**
 * @Class HandlerExceptions.java
 * 
 * @author <a href="mailto:henriquedreyer@gmail.com">Henrique Dreyer</a>
 *
 * @since 18 de fev de 2020
 */
package com.dreyer.algafoodapi.api.controller.exception;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.dreyer.algafoodapi.domain.exception.ObjectIntegrityViolationException;
import com.dreyer.algafoodapi.domain.exception.ObjectNotFoundException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

@ControllerAdvice
public class HandlerExceptions extends ResponseEntityExceptionHandler {
	
	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
				
		return super.handleExceptionInternal(ex, body, headers, status, request);
	}
	
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		Throwable throwable = ExceptionUtils.getRootCause(ex);
		
		if(throwable instanceof InvalidFormatException) {
			return handleInvalidFormatException((InvalidFormatException) throwable, headers, status, request);
		}
		
		return super.handleHttpMessageNotReadable(ex, headers, status, request);
	}
	
	@ExceptionHandler(value = ObjectNotFoundException.class)
	public ResponseEntity<Object> handleObjectNotFound(ObjectNotFoundException e, WebRequest request) {
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardErrorSpring standardErrorSpring = createStandardError(status, e).build();
		
		return handleExceptionInternal(e, standardErrorSpring, new HttpHeaders(), status, request);
	}
	
	@ExceptionHandler(value = ObjectIntegrityViolationException.class)
	public ResponseEntity<Object> handleIllegalArgument(ObjectIntegrityViolationException e, WebRequest request) {
		
		HttpStatus status = HttpStatus.CONFLICT;		
		StandardErrorSpring standardErrorSpring = createStandardError(status, e).build();
		
		return handleExceptionInternal(e, standardErrorSpring, new HttpHeaders(), status, request);
	}
		
	public ResponseEntity<Object> handleInvalidFormatException(InvalidFormatException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {		
		
		StandardErrorSpring standardErrorSpring = createStandardError(status, ex)
				.status(status.value())
				.title(status.name())
				.detail(ex.getMessage())
				.build();
		
		return handleExceptionInternal(ex, standardErrorSpring, headers, status, request);
	}
				
	private StandardErrorSpring.StandardErrorSpringBuilder createStandardError(HttpStatus httpStatus, Throwable ex) {
		return StandardErrorSpring.builder()
				.status(httpStatus.value())
				.title(httpStatus.name())
				.detail(ex.getMessage());
	}


}
