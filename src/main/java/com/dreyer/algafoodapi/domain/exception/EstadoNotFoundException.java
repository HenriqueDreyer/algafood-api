/**
 * @Class EstadoNotFoundException.java
 * 
 * @author <a href="mailto:henriquedreyer@gmail.com">Henrique Dreyer</a>
 *
 * @since 2 de jan de 2020
 */
package com.dreyer.algafoodapi.domain.exception;

public class EstadoNotFoundException extends ObjectNotFoundException{

	private static final long serialVersionUID = -717032293256734014L;
	
	public EstadoNotFoundException(String message) {
		super(message);
	}
	
	public EstadoNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

}
