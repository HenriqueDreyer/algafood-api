/**
 * @Class CozinhaIntegrityViolationException.java
 * 
 * @author <a href="mailto:henriquedreyer@gmail.com">Henrique Dreyer</a>
 *
 * @since 18 de fev de 2020
 */
package com.dreyer.algafoodapi.domain.exception;

public class CozinhaIntegrityViolationException extends ObjectIntegrityViolationException {

	private static final long serialVersionUID = -3319931699178527287L;

	/**
	 * @param message
	 * @param cause
	 */
	public CozinhaIntegrityViolationException(String message, Throwable cause) {
		super(message, cause);
	}

}
