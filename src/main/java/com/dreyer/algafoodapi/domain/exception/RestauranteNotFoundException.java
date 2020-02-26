/**
 * @Class RestauranteNotFoundException.java
 * 
 * @author <a href="mailto:henriquedreyer@gmail.com">Henrique Dreyer</a>
 *
 * @since 2 de jan de 2020
 */
package com.dreyer.algafoodapi.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RestauranteNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -8308491861348697088L;
	
	public RestauranteNotFoundException(String message) {
		super(message);
	}

}
