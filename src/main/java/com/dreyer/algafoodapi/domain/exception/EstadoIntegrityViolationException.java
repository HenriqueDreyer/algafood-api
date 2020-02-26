/**
 * @Class CidadeIllegalArgumentException.java
 * 
 * @author <a href="mailto:henriquedreyer@gmail.com">Henrique Dreyer</a>
 *
 * @since 17 de fev de 2020
 */
package com.dreyer.algafoodapi.domain.exception;

public class EstadoIntegrityViolationException extends ObjectIntegrityViolationException {
	
	private static final long serialVersionUID = 9163367334979460263L;

	public EstadoIntegrityViolationException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public EstadoIntegrityViolationException(String message) {
		super(message);
	}

}
