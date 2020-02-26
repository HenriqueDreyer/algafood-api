/**
 * @Class EntityNotFoundException.java
 * 
 * @author <a href="mailto:henriquedreyer@gmail.com">Henrique Dreyer</a>
 *
 * @since 15 de fev de 2020
 */
package com.dreyer.algafoodapi.domain.exception;

public abstract class ObjectNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = -9025638433695664393L;

	public ObjectNotFoundException(String message) {
		super(message);
	}
	
	public ObjectNotFoundException(String message, Throwable cause ) {
		super(message, cause);
	}
}
