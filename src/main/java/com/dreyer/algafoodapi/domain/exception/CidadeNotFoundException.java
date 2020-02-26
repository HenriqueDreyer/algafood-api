/**
 * @Class CidadeNotFoundException.java
 * 
 * @author <a href="mailto:henriquedreyer@gmail.com">Henrique Dreyer</a>
 *
 * @since 2 de jan de 2020
 */
package com.dreyer.algafoodapi.domain.exception;

public class CidadeNotFoundException extends ObjectNotFoundException{

	private static final long serialVersionUID = -4605963659149890415L;
	
	public CidadeNotFoundException(String message) {
		super(message);
	}
	
	public CidadeNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

}
