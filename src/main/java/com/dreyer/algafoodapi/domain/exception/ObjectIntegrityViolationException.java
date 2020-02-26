/**
 * @Class EntityIllegalArgumentException.java
 * 
 * @author <a href="mailto:henriquedreyer@gmail.com">Henrique Dreyer</a>
 *
 * @since 15 de fev de 2020
 */
package com.dreyer.algafoodapi.domain.exception;

public abstract class ObjectIntegrityViolationException extends RuntimeException{

	private static final long serialVersionUID = 1948121562160152384L;
	
	public ObjectIntegrityViolationException(String message) {
		super(message);
	}
	
	public ObjectIntegrityViolationException(String message, Throwable cause) {
		super(message, cause);
	}

}
